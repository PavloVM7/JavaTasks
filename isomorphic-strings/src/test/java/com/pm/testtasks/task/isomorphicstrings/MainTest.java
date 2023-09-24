package com.pm.testtasks.task.isomorphicstrings;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            'aabb', 'ccdd', true
            '', '', true
            'aabb', 'aabb', true
            'aabb', 'aacc', true
            'aaaa', 'bbcc', false
            'aabb', 'cccc', false
            'foo', 'food', false
            """)
    void isIsomorphic(String base, String other, boolean expected) {
        final var actual = Main.isIsomorphic(base, other);
        assertEquals(expected, actual);
    }

    @Test
    void isIsomorphic_exception() {
        assertThrows(NullPointerException.class, () -> Main.isIsomorphic("base", null));
        assertThrows(NullPointerException.class, () -> Main.isIsomorphic(null, "other"));
        assertThrows(NullPointerException.class, () -> Main.isIsomorphic(null, null));
    }
}