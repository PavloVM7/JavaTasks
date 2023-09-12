package com.pm.testtasks.task.mergeclassnames;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassnamesMergerTest {
    private ClassnamesMerger merger;

    static Stream<Arguments> getSuits() {
        return Stream.of(
                Arguments.of("button", new Object[]{"button"}),
                Arguments.of("button disabled primary",
                        new Object[]{"button", new String[]{"disabled", "primary"}}),
                Arguments.of("button disabled primary topper",
                        new Object[]{"button", new String[]{"disabled", "primary"}, "topper"}),
                Arguments.of("button disabled primary topper wow list",
                        new Object[]{"button", new String[]{"disabled", "primary"}, "topper", List.of("wow", "list")})
        );
    }

    @BeforeEach
    void setUp() {
        merger = new ClassnamesMerger();
    }

    @AfterEach
    void tearDown() {
        merger = null;
    }

    @Test
    void classesToString() {
        final var expected = "button primary list wow";
        final var actual = ClassnamesMerger.classesToString("button", new String[]{"button", "primary"},
                List.of("list", "wow"));
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getSuits")
    void mergeClasses(String expected, Object... sources) {
        merger.mergeClasses(sources);
        final var actual = merger.getClassesAsString();
        assertEquals(expected, actual);
    }

    @Test
    void getClasses() {
        merger.mergeClasses("button", new String[]{"disabled", "primary"}, List.of("wow", "list"));
        final var expected = new String[]{"button", "disabled", "primary", "wow", "list"};
        assertArrayEquals(expected, merger.getClasses());
    }

    @Test
    void mergeClasses_no_duplicate() {
        merger.mergeClasses("button", new String[]{"button", "primary"});
        assertArrayEquals(new String[]{"button", "primary"}, merger.getClasses());
    }
}