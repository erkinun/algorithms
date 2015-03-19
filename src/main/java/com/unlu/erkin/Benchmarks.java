package com.unlu.erkin;

import java.util.Arrays;
import java.util.Random;
/**
 * Created by unlue on 12/03/15.
 */
public class Benchmarks {

    public static void main(String[] args) {
        sortedArrayOp();
    }

    private static void sortedArrayOp() {
        short len = Short.MAX_VALUE;
        int[] array = new int[len];

        Random random = new Random(System.nanoTime());
        for (int i = 0; i < len; i++) {
            array[i] = random.nextInt() % 256;
        }

        //without the sort it runs slower:)
        Arrays.sort(array);

        long start = System.nanoTime();

        long sum = 0;
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < len; j++) {
                if (array[j] > 128) {
                    sum += array[j];
                }
            }
        }

        System.out.println((System.nanoTime() - start) / 1000000000.0);
        System.out.println("sum = " + sum);
    }
}
