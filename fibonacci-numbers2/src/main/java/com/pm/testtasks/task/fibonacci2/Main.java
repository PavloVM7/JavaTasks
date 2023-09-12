package com.pm.testtasks.task.fibonacci2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Fibonacci numbers 2 ***");
        for (var n : new int[]{5, 10, 20, 30}) {
            System.out.printf("Fibonacci for number %d is %d (also recursive %d)%n", n,
                    FibonacciNumbers2.calculate(n), FibonacciNumbers2.calculateRecursion(n));
        }
    }
}