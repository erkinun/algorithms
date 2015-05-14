package com.unlu.erkin.hackerrank;

/**
 * Created by ERKIN on 14/05/15.
 */
public class FindMinSorted {

    public static void main(String[] args) {
        int i = findMin(new int[]{1,2});

        System.out.println(i);
    }

    public static int findMin(int[] nums) {
        int size = nums.length;

        if (size == 1) { return nums[0]; }

        for (int i = 0; i < size; i++) {
            if (nums[i] < nums[((i-1)+size) % size]) {
                return nums[i];
            }
        }

        return -1; //not sorted
    }
}
