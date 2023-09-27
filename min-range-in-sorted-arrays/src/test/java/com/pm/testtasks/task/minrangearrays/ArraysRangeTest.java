package com.pm.testtasks.task.minrangearrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArraysRangeTest {
    private ArraysRange arraysRange;
    private int[] array1 = new int[]{4, 10, 15, 24, 26};
    private int[] array2 = new int[]{0, 9, 12, 20};
    private int[] array3 = new int[]{5, 18, 22, 30};
    private int[] expected = new int[]{20, 24};

    @BeforeEach
    void setUp() {
        array1 = new int[]{4, 10, 15, 24, 26};
        array2 = new int[]{0, 9, 12, 20};
        array3 = new int[]{5, 18, 22, 30};
        expected = new int[]{20, 24};

        arraysRange = new ArraysRange(array1, array2, array3);
    }

    @AfterEach
    void tearDown() {
        arraysRange = null;
        array1 = null;
        array2 = null;
        array3 = null;
        expected = null;
    }

    @Test
    void getMinRange() {
        final var range = arraysRange.getMinRange();
        assertTrue(range.isPresent());
        final var actual = range.get();
        assertArrayEquals(expected, actual, String.format("%s != %s", Arrays.toString(expected), Arrays.toString(actual)));
    }

    @Test
    void getMinRangeOptimal() {
        final var range = arraysRange.getMinRangeOptimized();
        assertTrue(range.isPresent());
        final var actual = range.get();
        assertArrayEquals(expected, actual, String.format("%s != %s", Arrays.toString(expected), Arrays.toString(actual)));
    }
}