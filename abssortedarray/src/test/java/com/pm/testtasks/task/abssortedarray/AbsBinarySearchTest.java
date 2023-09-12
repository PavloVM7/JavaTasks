package com.pm.testtasks.task.abssortedarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbsBinarySearchTest {

    @Test
    void find_near() {
        final var array = new int[]{-49, 49, 75, 103, -147, 164, 197, -197, -238, 314, 348, -422, 422};
        assertEquals(0, AbsBinarySearch.find(array, -49));
        assertEquals(1, AbsBinarySearch.find(array, 49));
        assertEquals(6, AbsBinarySearch.find(array, 197));
        assertEquals(7, AbsBinarySearch.find(array, -197));
        assertEquals(11, AbsBinarySearch.find(array, -422));
        assertEquals(12, AbsBinarySearch.find(array, 422));
    }

    @Test
    void find() {
        final var array = new int[]{-49, 75, 103, -147, 164, -197, -238, 314, 348, -422};
        for (var expected = 0; expected < array.length; expected++) {
            var fnd = array[expected];
            var actual = AbsBinarySearch.find(array, fnd);
            assertEquals(expected, actual);
            assertEquals(-1, AbsBinarySearch.find(array, -fnd));
        }
    }
}