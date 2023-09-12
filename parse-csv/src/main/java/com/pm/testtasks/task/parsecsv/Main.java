package com.pm.testtasks.task.parsecsv;

import java.io.File;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Parse a CSV file ***");
        final var file = new File(Objects.requireNonNull(Main.class.getClassLoader().getResource("numbers.csv"))
                .getFile());
        System.out.printf("File for parsing: '%s'%n", file.getName());
        try (final var parser = new ParserCSV(file)) {
            parser.parse();
            parser.print();
        } catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        System.out.println("*** Parse a CSV file");
    }
}