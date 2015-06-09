package com.unlu.erkin.leetcode;

/**
 * Created by ERKIN on 09/06/15.
 */
public class SingleNumber2 {
    //every element exists 3 times, only one is there single
    public int singleNumber(int[] nums) {

        int single = 0;
        for (int i = 0; i < 32; i++) {
            int countOne = 0;
            for(Integer num : nums) {
                countOne += (num >> i) & 1;
            }
            single |= (countOne%3) << i;
        }

        return single;
    }
}
