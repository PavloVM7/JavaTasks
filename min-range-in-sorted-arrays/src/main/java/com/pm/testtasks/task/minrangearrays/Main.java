package com.pm.testtasks.task.minrangearrays;

import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("Min range in sorted arrays ***");
        final int[] array1 = new int[]{4, 10, 15, 24, 26};
        final int[] array2 = new int[]{0, 9, 12, 20};
        final int[] array3 = new int[]{5, 18, 22, 30};
        final var range = getMinRangeInSortedArrays(array1, array2, array3);
        final var rangeOpt = getMinRangeInSortedArraysOptimized(array1, array2, array3);
        System.out.printf("array 1: %s%narray 2: %s%narray 3: %s%n",
                Arrays.toString(array1), Arrays.toString(array2), Arrays.toString(array3));
        System.out.printf("the smallest range:       %s%n", range.map(Arrays::toString).orElse("<not found>"));
        System.out.printf("the smallest range (opt): %s%n", rangeOpt.map(Arrays::toString).orElse("<not found>"));
        System.out.println("*** Min range in sorted arrays");
    }

    static Optional<int[]> getMinRangeInSortedArrays(int[]... arrays) {
        return new ArraysRange(arrays).getMinRange();
    }

    static Optional<int[]> getMinRangeInSortedArraysOptimized(int[]... arrays) {
        return new ArraysRange(arrays).getMinRangeOptimized();
    }
}