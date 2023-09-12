package com.pm.testtasks.task.countingintegers2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntegerArrayCounter {
    private final Map<Integer, Integer> integers = new HashMap<>();

    public String count(Integer[] ints) {
        integers.clear();
        counting(ints);
        final var list = new ArrayList<>(integers.entrySet());
        list.sort((o1, o2) -> -o1.getValue().compareTo(o2.getValue()));
        final StringBuilder sb = new StringBuilder();
        list.forEach(intEntry -> {
            if (!sb.isEmpty()) {
                sb.append(' ');
            }
            sb.append(intEntry.getKey()).append(':').append(intEntry.getValue()).append(',');
        });
        return sb.toString();
    }

    private void counting(Integer[] ints) {
        for (var num : ints) {
            var count = integers.get(num);
            if (count != null) {
                integers.put(num, ++count);
            } else {
                integers.put(num, 1);
            }
        }
    }
}
