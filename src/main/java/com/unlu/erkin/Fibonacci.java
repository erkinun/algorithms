package com.unlu.erkin;

/**
 * Created by unlue on 19/03/15.
 * By modern convention, the sequence begins either with F0 = 0 or with F1 = 1.
 * The Liber Abaci began the sequence with F1 = 1.
 * 0	1	1	2	3	5	8	13	21	34	55	89	144	233	377	610	987	1597	2584	4181	6765
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibRecursive(5));
        System.out.println(fibIter(6));
    }

    public static int fibRecursive(int n) {
        if (n == 0) { return 0; }

        if (n == 1) { return 1; }

        return fibRecursive(n-1) + fibRecursive(n-2);
    }

    public static int fibIter(int n) {

        if (n == 0) { return 0; }

        if (n == 1) { return 1; }

        int sum = 0;

        int two = 0; //two elems before
        int one = 1; //one elem before
        int counter = 2;
        while (counter <= n) {

            sum = two + one;
            two = one;
            one = sum;

            counter++;
        }

        return sum;
    }
}
