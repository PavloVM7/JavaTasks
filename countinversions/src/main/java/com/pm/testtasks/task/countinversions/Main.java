package com.pm.testtasks.task.countinversions;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Count Inversions ***");
        final int[] array = new int[]{2, 0, 5, 3, 2, 5};
        System.out.printf("Array '%s' count inversions is %d (concurrent %d)%n", Arrays.toString(array), count(array), countConcurrent(array));
        System.out.println("*** Count Inversions");
    }

    private static int count(int[] arr) {
        checkArray(arr);
        return InversionsCount.countBruteforce(arr);
    }

    private static int countConcurrent(int[] arr) {
        checkArray(arr);
        return InversionsCount.countConcurrent(arr);
    }

    private static void checkArray(int[] arr) {
        Objects.requireNonNull(arr, "Array parameter couldn't be null");
    }
}