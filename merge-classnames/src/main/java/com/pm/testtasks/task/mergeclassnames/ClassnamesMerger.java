package com.pm.testtasks.task.mergeclassnames;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;

public class ClassnamesMerger {
    private final LinkedHashSet<String> classes = new LinkedHashSet<>();

    public static String classesToString(Object... classes) {
        final var m = new ClassnamesMerger();
        m.mergeClasses(classes);
        return m.getClassesAsString();
    }

    public void mergeClasses(Object... names) {
        for (var val : names) {
            if (val instanceof String str) {
                classes.add(str);
            } else if (val instanceof String[] strings) {
                Collections.addAll(classes, strings);
            } else if (val instanceof Collection<?> collection) {
                for (var v : collection) {
                    if (v instanceof String s) {
                        classes.add(s);
                    }
                }
            }
        }
    }

    public String[] getClasses() {
        return classes.toArray(new String[0]);
    }

    public String getClassesAsString() {
        return String.join(" ", classes);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ClassnamesMerger that = (ClassnamesMerger) object;
        return Objects.equals(classes, that.classes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classes);
    }
}
