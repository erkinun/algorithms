package com.unlu.erkin.hackerrank;

import java.util.*;

public class PlusMinus {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        float count = scanner.nextInt();

        int number;
        int pos = 0;
        int neg = 0;
        int zeroes = 0;
        for (int i = 0; i < count; i++) {
            number = scanner.nextInt();

            if (number > 0) {
                pos++;
            }
            else if (number < 0) {
                neg++;
            }
            else {
                zeroes++;
            }
        }

        System.out.println(pos/count);
        System.out.println(neg/count);
        System.out.println(zeroes/count);

    }
}