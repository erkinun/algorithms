package com.unlu.erkin.sorting;

import java.util.Arrays;

/**
 * Created by ERKIN on 27/04/15.
 */
public class SelectionSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new Integer[]{10, 2, 8, 5, 1})));
    }

    public static <T extends Comparable<T>> T[] sort(T[] array) {
        if (array.length < 2) {
            return array;
        }

        for (int i = 0; i < array.length; i++) {

            T min = array[i];
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j].compareTo(min) < 0) {
                    min = array[j];
                    minIndex = j;
                }
            }

            T tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }

        return array;
    }
}
