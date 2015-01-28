package com.unlu.erkin;

import java.io.*;
import java.util.*;

public class Euler142 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < testCases; i++) {
            scanner.nextLine();
            int N = scanner.nextInt();

            int[] chains = new int[N+1];
            chains[0] = -1;
            for (int num = 1; num < N; num++) {
                chains[num] = calculateChain(num);
            }

            printMaxIndex(chains);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }

    private static int calculateChain(int num) {
        if (num == 1) {
            return 1;
        }
        else {
            int cur = num;
            int chainLength = 1;
            while (cur != 1) {
                chainLength++;
                if (cur % 2 == 0) {
                    cur = cur / 2;
                }
                else {
                    cur = (3 * cur) + 1;
                }
            }

            return chainLength;
        }
    }

    private static void printMaxIndex(int[] chains) {
        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < chains.length; i++) {
            if (chains[i] >= max) {
                max = chains[i];
                index = i;
            }
        }

        System.out.println(index);
    }
}