package com.unlu.erkin;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ERKIN on 05/05/15.
 */
public class Ranges {

    public static void main(String[] args) {
        List<Integer> integers = findInRange(50, 100);

        for (Integer integer : integers) {
            System.out.print(integer + ", ");
        }
    }

    private static List<Integer> findInRange(int from, int to) {
        int len = to - from;
        int[] nums = new int[len];

        for (int val = from, i = 0; val < to; i++, val++) {
            nums[i] = val;
        }

        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int rand = random.nextInt(len);
            integers.add(nums[rand]);
            len--;

            while(rand < len) {
                nums[rand] = nums[rand+1];
                rand++;
            }
        }

        return integers;
    }
}
