package com.unlu.erkin.codility;

/**
 * Created by ERKIN on 28/05/15.
 */
public class Equilibrium {
    public int solution(int[] A) {
        // write your code in Java SE 8

        int len = A.length;
        long[] toRight = new long[len];
        toRight[0] = 0;
        for (int i = 1; i < len; i++) {
            toRight[i] = toRight[i-1] + A[i-1];
        }

        long[] toLeft = new long[len];
        toLeft[len-1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            toLeft[i] = toLeft[i+1] + A[i+1];
        }

        for (int i = 0; i < len; i++) {
            if (toLeft[i] == toRight[i]) {
                return i;
            }
        }

        return -1;
    }
}
