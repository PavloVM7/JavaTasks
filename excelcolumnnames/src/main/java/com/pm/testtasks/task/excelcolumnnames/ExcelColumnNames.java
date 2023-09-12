package com.pm.testtasks.task.excelcolumnnames;

public final class ExcelColumnNames {
    static final int base = 26;

    private ExcelColumnNames() {
    }

    public static String indexToName(final int index) {
        final StringBuilder sb = new StringBuilder(7);
        int quotient = index;
        while (quotient-- > 0) {
            sb.append((char) ('A' + quotient % base));
            quotient /= base;
        }
        return sb.reverse().toString();
    }

    public static int nameToIndex(final String name) {
        int result = 0;
        for (int i = 0; i < name.length(); i++) {
            result = result * base + (name.charAt(i) - ('A' - 1));
        }
        return result;
    }
}
