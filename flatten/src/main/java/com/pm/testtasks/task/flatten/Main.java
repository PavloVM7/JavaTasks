package com.pm.testtasks.task.flatten;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Flatten ***");
        final var flattenAr = Flatten.flatten(new int[]{1, 2, 3}, new int[][]{{4, 5}, {6, 7, 8}}, new String[]{"string 1", "string 2"},
                new String[][]{{"string 3", "string 4", "string 5"}, {"string 6", "string 7", "string 8"}});
        System.out.println(Arrays.toString(flattenAr));
        System.out.println("*** Flatten");
    }
}