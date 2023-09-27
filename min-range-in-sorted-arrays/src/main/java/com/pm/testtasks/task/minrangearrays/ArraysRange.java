package com.pm.testtasks.task.minrangearrays;

import java.util.Optional;

public class ArraysRange {
    private final int[][] arrays;
    private final int[] indexes;

    private final SortableHeap heap;
    private int[] range;
    private boolean calculated;

    public ArraysRange(int[]... arrays) {
        this.arrays = new int[arrays.length][];
        System.arraycopy(arrays, 0, this.arrays, 0, this.arrays.length);
        indexes = new int[this.arrays.length];
        heap = new SortableHeap(this.arrays.length);
        calculated = false;
    }

    public Optional<int[]> getMinRange() {
        if (!calculated) {
            setRange();
        }
        return Optional.of(range);
    }

    public Optional<int[]> getMinRangeOptimized() {
        if (!calculated) {
            setRangeOpt();
        }
        return Optional.of(range);
    }

    void setRangeOpt() {
        int min = 0, max = 0, rng = -1, minArrayIdx;
        if (fillHeap()) {
            do {
                heap.sort();
                final var tmpMin = heap.getMin();
                final var tmpMax = heap.getMax();
                if (rng != -1) {
                    if (tmpMax.value() - tmpMin.value() < rng) {
                        min = tmpMin.value();
                        max = tmpMax.value();
                        rng = max - min;
                    }
                } else {
                    min = tmpMin.value();
                    max = tmpMax.value();
                    rng = max - min;
                }
                indexes[tmpMin.arrayIndex()]++;
                minArrayIdx = tmpMin.arrayIndex();
            } while (setHeapMinValue(minArrayIdx));
        }
        calculated = true;
        range = rng != -1 ? new int[]{min, max} : null;
    }

    void setRange() {
        int min = 0, max = 0, rng = -1;
        while (fillHeap()) {
            heap.sort();
            final var tmpMin = heap.getMin();
            final var tmpMax = heap.getMax();
            if (rng != -1) {
                if (tmpMax.value() - tmpMin.value() < rng) {
                    min = tmpMin.value();
                    max = tmpMax.value();
                    rng = max - min;
                }
            } else {
                min = tmpMin.value();
                max = tmpMax.value();
                rng = max - min;
            }
            indexes[tmpMin.arrayIndex()]++;
        }
        calculated = true;
        range = rng != -1 ? new int[]{min, max} : null;
    }

    private boolean fillHeap() {
        heap.clear();
        for (var i = 0; i < indexes.length; i++) {
            final var idx = indexes[i];
            final var array = arrays[i];
            if (idx >= array.length) {
                return false;
            }
            heap.add(i, array[idx]);
        }
        return true;
    }

    private boolean setHeapMinValue(int arrayIdx) {
        final var idx = indexes[arrayIdx];
        final var array = arrays[arrayIdx];
        if (idx < array.length) {
            heap.setMin(arrayIdx, array[idx]);
            return true;
        }
        return false;
    }
}
