package com.pm.testtasks.task.integertowords;

public class Main {
    public static void main(String[] args) {
        System.out.println("Integer to English Words ***");
        var number = 1234;
        var words = NumberToWords.numberToWords(number);
        System.out.printf("%d --> \"%s\"%n", number, words);
        System.out.println("*** Integer to English Words");
    }
}