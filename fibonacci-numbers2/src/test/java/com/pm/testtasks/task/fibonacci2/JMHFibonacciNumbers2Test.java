package com.pm.testtasks.task.fibonacci2;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
//@Fork(value = 3, warmups = 1)
public class JMHFibonacciNumbers2Test {
    private static final int number = 50;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHFibonacciNumbers2Test.class.getSimpleName())
                .forks(1)
                .warmupIterations(3)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public int calculateRecursion() {
        return FibonacciNumbers2.calculateRecursion(number);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public int calculate() {
        return FibonacciNumbers2.calculate(number);
    }
}