package com.unlu.erkin;

/**
 * Created by ERKIN on 17/02/15.
 */
public class BitOperations {

    public static void main(String[] args) {
        bitSubstring(0x0015,0x0400, 2, 6);

        int hede = 53;

        while (hede > 0) {
            hede = hede >> 1;
        }

        System.out.println("hede is now: " + hede);

        System.out.println("we have to change for 31 and 14: " + setCountDiff(31, 14));
    }

    public static void bitSubstring(int n, int m, int start, int j) {
        int temp = 0;

        System.out.println(Integer.toBinaryString(n));

        for (int i = 0; i < 32; i++) {
            if (i >= start && i <= j) {
                temp = temp | (1 << i);
            }
        }

        System.out.println(Integer.toBinaryString(temp));

        temp = n & temp;
        System.out.println(Integer.toBinaryString(temp));
        int result = m | temp;

        System.out.println(Integer.toBinaryString(result));
    }

    public static int setCountDiff(int a, int b) {
        int a1 = 0;
        int b1 = 0;

        int temp = a;

        while (temp > 0) {
            if ((temp & 0x01) == 1) {
                a1++;
            }
            temp = temp >> 1;
        }

        temp = b;

        while (temp > 0) {
            if ((temp & 0x01) == 1) {
                b1++;
            }
            temp = temp >> 1;
        }

        return Math.abs(a1 - b1);
    }
}
