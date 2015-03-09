package com.unlu.erkin;

import java.util.Arrays;

/**
 * Created by ERKIN on 09/03/15.
 */
public class QuickSortImpl {

    public static void main(String[] args) {
        int[] data = {5,1,4,8,9,2,11};

        quickSort(data, 0, data.length - 1);

        System.out.println(Arrays.toString(data));
    }

    private static void quickSort(int[] data, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = data[lo];

        int curLo = lo + 1;
        int curHi = hi;

        while (true) {
            while (data[curLo] < pivot) { curLo++; }
            while (data[curHi] > pivot && curHi != 0) { curHi--; }

            if (curHi == 0) { return; }

            if (curHi <= curLo) {
                //swap pivot
                int pivotInd;
                if (pivot < data[curLo]) {
                    pivotInd = curLo - 1;
                }
                else {
                    pivotInd = curLo;
                }
                int temp = data[pivotInd];
                data[pivotInd] = pivot;
                data[lo] = temp;
                //quicksort left
                quickSort(data, lo, pivotInd - 1);
                //quicksort right
                quickSort(data, pivotInd + 1, hi);

                return;
            }

            int temp = data[curLo];
            data[curLo] = data[curHi];
            data[curHi] = temp;
            curLo++;
            curHi--;
        }
    }
}
