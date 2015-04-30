package com.unlu.erkin.concurrency;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by ERKIN on 30/04/15.
 */
public class ConcMain {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        FibFork fibFork = new FibFork(46, 10);
        pool.invoke(fibFork);

        long finish = System.currentTimeMillis();

        System.out.println("result of fib: " + fibFork.getResult());
        System.out.println("duration of operation with forkjoin:" + (finish - start));

        start = System.currentTimeMillis();

        long result = fibFork.computeSeq(46);

        finish = System.currentTimeMillis();

        System.out.println("result of fib: " + result);
        System.out.println("duration of operation sequentially:" + (finish - start));

    }
}
