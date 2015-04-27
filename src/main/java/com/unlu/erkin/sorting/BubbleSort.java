package com.unlu.erkin.sorting;

import java.util.Arrays;

/**
 * Created by ERKIN on 27/04/15.
 */
public class BubbleSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new Integer[]{10, 2, 8, 5, 1})));
    }

    public static <T extends Comparable<T>> T[] sort(T[] array) {
        if (array.length < 2) {
            return array;
        }

        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j+1]) > 0) {
                    T tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }

        return array;
    }
}
