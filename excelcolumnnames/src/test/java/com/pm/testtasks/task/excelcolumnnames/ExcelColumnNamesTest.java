package com.pm.testtasks.task.excelcolumnnames;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExcelColumnNamesTest {

    @Test
    void nameToIndex() {
        assertEquals(702, ExcelColumnNames.nameToIndex("ZZ"));
    }

    @Test
    void indexToName_2() {
        for (var i = 1; i <= 26; i++) {
            var letter1 = String.valueOf((char) ('A' + (i - 1)));
            var start = 26 * i + 1;
            var end = 26 * (i + 1);
            var letter2offset = -1;
            for (var j = start; j <= end; j++) {
                final var actual = ExcelColumnNames.indexToName(j);
                final var expected = letter1 + (char) ('A' + ++letter2offset);
                if (j == start) {
                    System.out.printf("%3d == '%s'('%s')%n", j, actual, expected);
                    System.out.println("...");
                } else if (j == end) {
                    System.out.printf("%3d == '%s'('%s')%n", j, actual, expected);
                }

            }
        }
    }

    @Test
    void indexToName_1() {
        for (var i = 1; i <= 26; i++) {
            final var actual = ExcelColumnNames.indexToName(i);
            final var expected = String.valueOf((char) ('A' + i - 1));
            System.out.printf("%2d == '%s'%n", i, actual);
            assertEquals(expected, actual);
        }
    }
}