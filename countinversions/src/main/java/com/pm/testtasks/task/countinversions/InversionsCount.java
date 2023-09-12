package com.pm.testtasks.task.countinversions;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class InversionsCount {
    private InversionsCount() {
    }

    public static int countBruteforce(int[] arr) {
        int result = 0;
        for (var i = 0; i < arr.length - 1; i++) {
            for (var j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    result++;
                }
            }
        }
        return result;
    }

    public static int countConcurrent(int[] arr) {
        final var threads = 4;
        final var pool = Executors.newFixedThreadPool(threads);
        final var futures = new Future[threads];
        for (var i = 0; i < futures.length; i++) {
            futures[i] = pool.submit(new InversionsPartialCalculator(arr, i, threads));
        }
        int result = 0;
        try {
            for (var future : futures) {
                result += (Integer) future.get();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        pool.shutdown();
        try {
            //noinspection ResultOfMethodCallIgnored
            pool.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private record InversionsPartialCalculator(int[] array, int startIndex, int step) implements Callable<Integer> {

        @Override
        public Integer call() {
            int result = 0;
            for (var i = startIndex; i < array.length - 1; i += step) {
                for (var j = i + 1; j < array.length; j++) {
                    if (array[i] > array[j]) {
                        result++;
                    }
                }
            }
            return result;
        }
    }
}
