package com.pm.testtasks.task.minrangearrays;

import java.util.Objects;

record ArrayIndexValue(int arrayIndex, int value) {
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ArrayIndexValue that = (ArrayIndexValue) object;
        return arrayIndex == that.arrayIndex && value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrayIndex, value);
    }
}
