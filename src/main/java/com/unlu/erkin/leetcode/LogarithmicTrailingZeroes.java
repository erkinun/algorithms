package com.unlu.erkin.leetcode;

/**
 * Created by ERKIN on 26/05/15.
 */
public class LogarithmicTrailingZeroes {

    public int trailingZeroes(int n) {

        int zeroCount = 0;
        while (n >= 5) {
            zeroCount += n / 5;
            n /= 5;
        }

        return zeroCount;
    }
}
