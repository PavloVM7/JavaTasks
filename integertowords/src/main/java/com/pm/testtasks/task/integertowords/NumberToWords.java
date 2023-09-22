package com.pm.testtasks.task.integertowords;

public class NumberToWords {
    private static final String[] belowTen = new String[]{
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] belowTwenty = new String[]{
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] belowHundred = new String[]{
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String zero = "Zero";
    private static final String hundred = "Hundred";
    private static final String thousand = "Thousand";

    public static String numberToWords(int number) {
        if (number == 0) {
            return zero;
        }
        return numToWordRecursive(number);
    }

    private static String numToWordRecursive(int num) {
        var result = "";
        if (num < 10) {
            result = belowTen[num];
        } else if (num < 20) {
            result = belowTwenty[num - 10];
        } else if (num < 100) {
            result = belowHundred[num / 10] + " " + numToWordRecursive(num % 10);
        } else if (num < 1000) {
            result = numToWordRecursive(num / 100) + " " + hundred + " " + numToWordRecursive(num % 100);
        } else {
            result = numToWordRecursive(num / 1000) + " " + thousand + " " + numToWordRecursive(num % 1000);
        }
        return result.stripTrailing();
    }

}
