package com.pm.testtasks.task.fizzbuzz;

public class Main {
    private static final int start = 1;
    private static final int end = 100;
    private static final String fizz = "fizz";
    private static final String buzz = "buzz";
    private static final int div3 = 3;
    private static final int div5 = 5;

    public static void main(String[] args) {
        System.out.println("FizzBuzz ***");
        final StringBuilder sb = new StringBuilder(fizz.length() + buzz.length());
        for (var i = start; i <= end; i++) {
            sb.setLength(0);
            if (i % div3 == 0) {
                sb.append(fizz);
            }
            if (i % div5 == 0) {
                sb.append(buzz);
            }
            System.out.printf("%3d: %s%n", i, sb);
        }
        System.out.println("*** FizzBuzz");
    }
}