package com.pm.testtasks.task.rgbcolorformatter;

public class Main {
    public static void main(String[] args) {
        System.out.println("RGB color formatter ***");
        final var formatter = new RGBColorFormatter();
        System.out.println(formatter.format(0, 0, 0));
        System.out.println(formatter.format(127, 127, 127));
        System.out.println(formatter.format(128, 128, 128));
        System.out.println(formatter.format(255, 255, 255));
        System.out.println("*** RGB color formatter");
    }
}