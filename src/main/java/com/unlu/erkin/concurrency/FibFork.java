package com.unlu.erkin.concurrency;

import java.util.concurrent.RecursiveAction;

/**
 * Created by ERKIN on 30/04/15.
 */
public class FibFork extends RecursiveAction {

    private final int fibToFound;
    private final int threshold;
    private long result;

    public FibFork(int fibToFound, int threshold) {
        this.fibToFound = fibToFound;
        this.threshold = threshold;
    }

    public long getResult() {
        return result;
    }

    public long computeSeq(int fibToF) {
        if (fibToF <= 2) {
            return 1;
        }
        else {
            return computeSeq(fibToF - 1) + computeSeq(fibToF - 2);
        }
    }

    @Override
    protected void compute() {
        if (fibToFound <= threshold) {
            result = computeSeq(fibToFound);
        }
        else {
            FibFork f1 = new FibFork(fibToFound - 1, threshold);
            FibFork f2 = new FibFork(fibToFound - 2, threshold);
            invokeAll(f1, f2);

            result = f1.result + f2.result;
        }
    }
}
