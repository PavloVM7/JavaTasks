package com.pm.testtasks.task.minrangearrays;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JmhArraysRangeTest {
    private ArraysRange arraysRange;
    private int[] array1;
    private int[] array2;
    private int[] array3;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhArraysRangeTest.class.getSimpleName())
                .forks(1)
                .warmupIterations(3)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

    @Setup(Level.Invocation)
    public void setUp() {
        array1 = new int[]{4, 10, 15, 24, 26};
        array2 = new int[]{0, 9, 12, 20};
        array3 = new int[]{5, 18, 22, 30};

        arraysRange = new ArraysRange(array1, array2, array3);
    }

    @TearDown(Level.Invocation)
    public void tearDown() {
        arraysRange = null;
        array1 = null;
        array2 = null;
        array3 = null;
    }

    @Benchmark
    public Optional<int[]> getMinRange() {
        return arraysRange.getMinRange();
    }

    @Benchmark
    public Optional<int[]> getMinRangeOptimized() {
        return arraysRange.getMinRangeOptimized();
    }
}