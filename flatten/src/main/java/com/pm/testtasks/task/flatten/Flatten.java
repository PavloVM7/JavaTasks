package com.pm.testtasks.task.flatten;

import java.lang.reflect.Array;
import java.util.LinkedList;

public final class Flatten {
    private Flatten() {
    }

    public static Object[] flatten(Object... arrays) {
        final LinkedList<Object> res = new LinkedList<>();
        for (var ar : arrays) {
            if (ar.getClass().isArray()) {
                res.addAll(flat(ar));
            } else {
                res.addLast(ar);
            }
        }
        return res.toArray();
    }

    static LinkedList<Object> flat(Object array) {
        final LinkedList<Object> result = new LinkedList<>();
        if (array.getClass().isArray()) {
            final var length = Array.getLength(array);
            for (var i = 0; i < length; i++) {
                final var val = Array.get(array, i);
                if (val == null) {
                    result.addLast(null);
                } else if (val.getClass().isArray()) {
                    result.addAll(flat(val));
                } else if (val instanceof LinkedList<?> list) {
                    result.addAll(list);
                } else {
                    result.addLast(val);
                }
            }
        } else {
            result.addLast(array);
        }
        return result;
    }
}
