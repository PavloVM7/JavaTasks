package com.pm.testtasks.task.parsecsv;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ParserCSV implements Closeable {
    private final LineNumberReader reader;
    private final SortedMap<String, String[]> sortedLines;
    private final List<LineNumberString> errors;

    public ParserCSV(File file) throws FileNotFoundException {
        reader = new LineNumberReader(new BufferedReader(new FileReader(file), 128 * 1024));
        sortedLines = new TreeMap<>(String::compareTo);
        errors = new LinkedList<>();
    }

    public void parse() throws IOException {
        sortedLines.clear();
        errors.clear();
        final String separator = ",";
        var line = reader.readLine();
        while (line != null) {
            final var ar = line.split(separator);
            if (ar.length > 2) {
                sortedLines.put(ar[2], ar);
            } else {
                errors.add(new LineNumberString(reader.getLineNumber(), line));
            }
            line = reader.readLine();
        }
    }

    public void print() {
        printErrors();
        printLines();
    }

    private void printLines() {
        sortedLines.forEach((string, strings) -> System.out.printf("%s: %s%n", string, strings[2]));
    }

    private void printErrors() {
        if (!errors.isEmpty()) {
            for (var err : errors) {
                System.out.printf("Line number %d ('%s') doesn't have enough columns%n", err.lineNumber, err.string);
            }
        }
    }

    int errorsCount() {
        return errors.size();
    }

    int linesCount() {
        return sortedLines.size();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

    private static class LineNumberString {
        private final int lineNumber;
        private final String string;

        private LineNumberString(int lineNumber, String string) {
            this.lineNumber = lineNumber;
            this.string = string;
        }
    }
}
