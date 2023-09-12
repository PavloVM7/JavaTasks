package com.pm.testtasks.task.countingintergers;

import java.util.Random;

public class Main {
    private static final int maxNum = 10;
    private static final int amountNumbers = 100;

    private static void printCount(int num, int count) {
        System.out.printf(" %d | %s%n", num, "*".repeat(count));
    }

    public static void main(String[] args) {
        System.out.println("*** Counting Integers (Histogram)");
        final Random random = new Random();
        final int[] counters = new int[maxNum];

        for (var i = 0; i < amountNumbers; i++) {
            final var num = random.nextInt(maxNum);
            counters[num]++;
        }
        for (var i = 0; i < counters.length; i++) {
            printCount(i, counters[i]);
        }
        System.out.println("Counting Integers (Histogram) ***");
    }
}