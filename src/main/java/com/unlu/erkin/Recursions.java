package com.unlu.erkin;

/**
 * Created by ERKIN on 29/01/15.
 */
public class Recursions {

    public static void main(String[] args) {

        int[] sorted = new int[] {1,2,3,4,5};

        binarySearch(sorted, 1);
        binarySearch(sorted, 4);
        binarySearch(sorted, 7);
    }

    private static void binarySearch(int[] sorted, int num) {
        int start = 0;
        int end = sorted.length - 1;

        innerBinary(sorted, num, start, end);
    }

    private static void innerBinary(int[] sorted, int num, int start, int end) {
        int index = ((end - start) / 2) + start;

        if (index < 0 || index >= sorted.length) {
            System.out.println("not found!");
            return;
        }

        if (num == sorted[index]) {
            System.out.println("found it at index: " + index);
        }
        else if (num < sorted[index]) {
            innerBinary(sorted, num, start, index-1);
        }
        else {
            innerBinary(sorted, num, index+1, end);
        }
    }
}
