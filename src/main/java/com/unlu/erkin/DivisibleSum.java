package com.unlu.erkin;

/**
 * Created by ERKIN on 15/02/15.
 */
public class DivisibleSum {

    public static void main(String[] args) {

        System.out.println(sumOfDivisble3Or5(9));
    }

    public static int sumOfDivisble3Or5(int limit) {
        int sum = 0;
        int counter = 0;

        while (counter < limit) {
            if (counter % 3 == 0 || counter % 5 == 0) {
                sum += counter;
            }
            counter++;
        }

        return sum;
    }
}
