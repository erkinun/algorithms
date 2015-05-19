package com.unlu.erkin.leetcode;

/**
 * Created by ERKIN on 19/05/15.
 */
public class PrimeCount {

    public static void main(String[] args) {
        PrimeCount count = new PrimeCount();

        System.out.println(count.countPrimes(10));
    }

    public int countPrimes(int n) {

        //sieve of Eratosthenes
        if (n == 0 || n == 1 || n == 2) { return 0; }

        boolean[] marks = new boolean[n];
        marks[0] = true;
        marks[1] = true;
        int primeCount = 0;
        for (int i = 0; i < n; i++) {
            if (!marks[i]) {
                primeCount++;
                int prime = i;
                for (int c = prime + prime; c < n; c += prime) {
                    marks[c] = true;
                }
            }
        }


        return primeCount++;
    }
}
