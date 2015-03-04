package com.unlu.erkin;

/**
 * Created by ERKIN on 15/02/15.
 */
public class DigitFinder {

    public static void main(String[] args) {

        System.out.println(findPages(4, 0));

        System.out.println(str2Int("456"));
        System.out.println(str2Int("-456"));
    }

    public static int findPages(int digit, int occ) {
        int current = 0;

        int pages = 0;
        int minRequired = -1;
        boolean found = false;
        while (current <= occ) {
            current += numHasDigit(pages, digit);

            if (current == occ && !found) {
                minRequired = pages;
                found = true;
            }

            pages++;
        }

        System.out.println("min required: " + minRequired);

        return pages;
    }

    private static int numHasDigit(int page, int digit) {
        int occr = 0;
        char digitC = String.valueOf(digit).charAt(0);

        char[] pageS = String.valueOf(page).toCharArray();

        for (Character c : pageS) {
            if (c == digitC) { occr++; }
        }

        return occr;
    }

    private static int str2Int(String num) {
        char[] number = num.toCharArray();

        boolean neg = false;

        if (number[0] == '-') {
            neg = true;
        }

        int finish = neg ? 1 : 0;

        int step = 0;
        int sum = 0;
        for (int i = number.length-1; i >= finish; i--) {
            sum += digit(number[i]) * (Math.pow(10, step++));
        }

        return neg ? -sum : sum;

    }

    private static int digit(char c) {
        return c - '0';
    }
}
