package com.unlu.erkin;

/**
 * Created by unlue on 06/03/15.
 */
public class Words {

    //TODO should also work on odd lengthed number stringsum
    public static void main(String[] args) {
        System.out.println(nextPalindrome("1392"));
    }

    private static int nextPalindrome(String number) {

        int middle;
        int length = number.length();


        if (length % 2 == 1) {
            middle = (length / 2) + 1;
        }
        else {
            middle = length / 2;
        }

        String half = number.substring(0, middle);

        boolean found = false;

        int numInt = Integer.valueOf(number);
        int inc = 0;

        int halfInt = Integer.valueOf(half);
        while (true) {

            halfInt += inc;
            inc += 1;

            half = String.valueOf(halfInt);

            System.out.println(half);

            StringBuilder builder = new StringBuilder(half);


            String palindrome = half + builder.reverse().toString();

            System.out.println(palindrome);

            int palInt = Integer.valueOf(palindrome);

            if (palInt >= numInt) {
                return palInt;
            }
        }

    }
}
