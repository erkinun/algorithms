package com.unlu.erkin;

/**
 * Created by ERKIN on 15/02/15.
 */
public class DigitFinder {

    public static void main(String[] args) {

        System.out.println(findPages(4, 0));
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
}
