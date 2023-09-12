package com.pm.testtasks.task.abssortedarray;

public class Main {
    public static void main(String[] args) {
        System.out.println("Search for a pair in abs-sorted array ***");
        final var array = new int[]{-49, 75, 103, -147, 164, -197, -238, 314, 348, -422};
        final var val1 = 167;
        var pair1 = findPair(array, val1);
        printResult(val1, pair1);
        final var val2 = -74;
        var pair2 = findPair(array, val2);
        printResult(val2, pair2);
        final var val3 = 123;
        var pair3 = findPair(array, val3);
        printResult(val3, pair3);
        final var val4 = 389;
        var pair4 = findPair(array, val4);
        printResult(val4, pair4);
        System.out.println("*** Search for a pair in abs-sorted array");
    }

    private static IndexPair findPair(int[] array, int k) {
        for (var i = 0; i < array.length; i++) {
            var fst = array[i];
            var scd = k - fst;
            var idx = AbsBinarySearch.find(array, scd);
            if (idx != -1) {
                return new IndexPair(i, idx);
            }
        }
        return new IndexPair(-1, -1);
    }

    private static void printResult(int val, IndexPair pair) {
        System.out.printf("value: %d, (%d;%d)%n", val, pair.firs(), pair.second());
    }
}