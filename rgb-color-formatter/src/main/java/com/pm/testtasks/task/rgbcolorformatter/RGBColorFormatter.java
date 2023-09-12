package com.pm.testtasks.task.rgbcolorformatter;

public final class RGBColorFormatter {
    private static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    private static final int hex = 16;

    static String toHex(int val) {
        if (val > 0xFF) {
            throw new IllegalArgumentException("wrong RGB value: " + val);
        }
        int d1 = val / hex;
        int d2 = val % hex;
        return hexDigits[d1] + hexDigits[d2];
    }

    public String format(int r, int g, int b) {
        return "#" + toHex(r) + toHex(g) + toHex(b);
    }


}
