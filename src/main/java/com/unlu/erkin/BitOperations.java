package com.unlu.erkin;

/**
 * Created by ERKIN on 17/02/15.
 */
public class BitOperations {

    public static void main(String[] args) {
        bitSubstring(0x0015,0x0400, 2, 6);
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
}
