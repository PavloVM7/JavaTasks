package com.pm.testtasks.task.countinversions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InversionsCountTest {
    private static final int[] array = new int[]{2, 0, 5, 3, 2, 5};
    private static final int expected = 4;

    @Test
    void countBruteforce() {
        assertEquals(expected, InversionsCount.countBruteforce(array));
    }

    @Test
    void countConcurrent() {
        assertEquals(expected, InversionsCount.countConcurrent(array));
    }
}