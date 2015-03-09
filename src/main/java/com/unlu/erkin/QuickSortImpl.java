package com.unlu.erkin;

import java.util.Arrays;

/**
 * Created by ERKIN on 09/03/15.
 */
public class QuickSortImpl {

    public static void main(String[] args) {
        Integer[] data = {5,1,4,8,9,2,11};

        quickSort(data, 0, data.length - 1);

        System.out.println(Arrays.toString(data));
    }

    private static <T extends Comparable<T>> void quickSort(T[] data, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        T pivot = data[lo];

        int curLo = lo + 1;
        int curHi = hi;

        while (true) {
            while (data[curLo].compareTo(pivot) < 0) { curLo++; }
            while (data[curHi].compareTo(pivot) > 0 && curHi != 0) { curHi--; }

            if (curHi == 0) { return; }

            if (curHi <= curLo) {
                //swap pivot
                int pivotInd;
                if (pivot.compareTo(data[curLo]) < 0) {
                    pivotInd = curLo - 1;
                }
                else {
                    pivotInd = curLo;
                }
                T temp = data[pivotInd];
                data[pivotInd] = pivot;
                data[lo] = temp;
                //quicksort left
                quickSort(data, lo, pivotInd - 1);
                //quicksort right
                quickSort(data, pivotInd + 1, hi);

                return;
            }

            T temp = data[curLo];
            data[curLo] = data[curHi];
            data[curHi] = temp;
            curLo++;
            curHi--;
        }
    }
}
