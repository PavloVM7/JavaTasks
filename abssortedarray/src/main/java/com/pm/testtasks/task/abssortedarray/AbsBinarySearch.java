package com.pm.testtasks.task.abssortedarray;

public final class AbsBinarySearch {
    private AbsBinarySearch() {
    }

    public static int find(int[] absSortedArray, int value) {
        int first = 0;
        int last = absSortedArray.length - 1;
        int mid = (first + last) / 2;
        final int absSource = Math.abs(value);
        while (first <= last) {
            var abs = Math.abs(absSortedArray[mid]);
            if (abs < absSource) {
                first = mid + 1;
            } else if (abs == absSource) {
                if (absSortedArray[mid] == value) {
                    return mid;
                } else {
                    var index = mid - 1;
                    if (index >= 0 && absSortedArray[index] == value) {
                        return index;
                    } else {
                        index = mid + 1;
                        if (index < absSortedArray.length && absSortedArray[index] == value) {
                            return index;
                        }
                        return -1;
                    }
                }
            } else {
                last = mid - 1;
            }
            mid = (first + last) >> 1;
        }
        return -1;
    }
}
