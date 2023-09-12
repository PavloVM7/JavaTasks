package com.pm.testtasks.task.excelcolumnnames;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Excel Column Names");
        for (var i = 1; i < 56; i++) {
            final var name = ExcelColumnNames.indexToName(i);
            final var index = ExcelColumnNames.nameToIndex(name);
            System.out.printf("number: %3d, name: %s, index: %3d%n", i, name, index);
        }

        System.out.println("Excel Column Names ***");
    }
}