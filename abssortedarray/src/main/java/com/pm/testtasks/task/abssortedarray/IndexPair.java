package com.pm.testtasks.task.abssortedarray;

import java.util.Objects;

public record IndexPair(int firs, int second) {
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        IndexPair indexPair = (IndexPair) object;
        return firs == indexPair.firs && second == indexPair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firs, second);
    }

    @Override
    public String toString() {
        return "IndexPair{" +
                "firs=" + firs +
                ", second=" + second +
                '}';
    }
}
