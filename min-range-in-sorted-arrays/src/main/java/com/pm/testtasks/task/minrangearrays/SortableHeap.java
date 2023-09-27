package com.pm.testtasks.task.minrangearrays;

import java.util.Arrays;
import java.util.Comparator;

class SortableHeap {
    final ArrayIndexValue[] heap;
    boolean sorted;

    SortableHeap(int length) {
        heap = new ArrayIndexValue[length];
        sorted = false;
    }

    void sort() {
        Arrays.sort(heap, Comparator.comparingInt(ArrayIndexValue::value).thenComparingInt(ArrayIndexValue::arrayIndex));
        sorted = true;
    }

    ArrayIndexValue getMin() {
        if (!sorted) {
            sort();
        }
        return heap[0];
    }

    ArrayIndexValue getMax() {
        if (!sorted) {
            sort();
        }
        return heap[heap.length - 1];
    }

    void setMin(int arrayIndex, int value) {
        set(0, new ArrayIndexValue(arrayIndex, value));
    }

    void add(int arrayIndex, int value) {
        add(new ArrayIndexValue(arrayIndex, value));
    }

    void add(ArrayIndexValue indexValue) {
        for (var i = 0; i < heap.length; i++) {
            if (heap[i] == null) {
                set(i, indexValue);
                return;
            }
        }
        throw new IllegalStateException("Heap is full.");
    }

    private void set(int idx, ArrayIndexValue indexValue) {
        heap[idx] = indexValue;
        sorted = false;
    }

    void clear() {
        Arrays.fill(heap, null);
        sorted = false;
    }
}
