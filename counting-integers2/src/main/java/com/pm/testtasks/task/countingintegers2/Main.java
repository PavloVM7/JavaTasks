package com.pm.testtasks.task.countingintegers2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Counting integers 2 ***");
        var array = new Integer[]{1, 30, 1, 1, 5, 12, 5};
        System.out.println(new IntegerArrayCounter().count(array));
        System.out.println("*** Counting integers 2");
    }
}