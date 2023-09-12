package com.pm.testtasks.task.flatten;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlattenTest {

    private static void assertArrays(Object expected, Object actual) {
        assertTrue(expected.getClass().isArray());
        assertTrue(actual.getClass().isArray());
        final var lenExpected = Array.getLength(expected);
        assertEquals(lenExpected, Array.getLength(actual));
        for (var i = 0; i < lenExpected; i++) {
            assertEquals(Array.get(expected, i), Array.get(actual, i));
        }
    }

    static Stream<Arguments> getArrays() {
        return Stream.of(
                Arguments.arguments(new int[][]{{1, 2}, {3, 4, 5}}, List.of(1, 2, 3, 4, 5)),
                Arguments.arguments(new String[]{"String 1", "String 2", "string 3"}, List.of("String 1", "String 2", "string 3")),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, List.of(1, 2, 3, 4, 5))
        );
    }

    @Test
    void flatten() {
        final var int1 = new int[]{1, 2, 3};
        final var int2 = new int[][]{{4, 5}, {6, 7, 8}};
        final var str1 = new String[]{"string 1", "string 2"};
        final var str2 = new String[][]{{"string 3", "string 4", "string 5"}, {"string 6", "string 7", "string 8"}};
        final var actual = Flatten.flatten(int1, int2, str1, str2);
        final var expected = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, "string 1", "string 2", "string 3", "string 4", "string 5", "string 6", "string 7", "string 8"};
        assertArrays(expected, actual);
    }

    @Test
    void flat_array_string() {
        final var array = new String[]{"sting 1", "string 2", "string 3"};
        final var actual = Flatten.flat(array);
        final var expected = List.of(array);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getArrays")
    void flat_array(Object array, Object expected) {
        final var actual = Flatten.flat(array);
        assertEquals(expected, actual);
    }

    @Test
    void flat_simple() {
        assertEquals(List.of(1), Flatten.flat(1));
        assertEquals(List.of("string string"), Flatten.flat("string string"));
        final var expected = new IllegalArgumentException("exception");
        assertEquals(List.of(expected), Flatten.flat(expected));
    }
}