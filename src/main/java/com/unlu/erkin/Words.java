package com.unlu.erkin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by unlue on 06/03/15.
 */
public class Words {

    //TODO should also work on odd lengthed number stringsum
    public static void main(String[] args) {
        System.out.println(nextPalindrome("1392"));

        System.out.println(removeDuplicates("tree traversal"));

        List<String> substrs = palindromes("helle");

        for (String s : substrs) {
            System.out.println(s);
        }
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

    public static String removeDuplicates(String word) {
        char[] stringA = word.toCharArray();

        boolean[] hit = new boolean[256];

        for (int i = 0; i < 256; i++) {
            hit[i] = false;
        }

        hit[stringA[0]] = true;
        int tail = 1;

        int len = word.length();
        for (int i = 1; i < len; i++) {
            if (!hit[stringA[i]]) {
                //unique char
                stringA[tail] = stringA[i];
                tail++;
                hit[stringA[i]] = true;
            }
        }


        return new String(stringA).substring(0, tail);
    }

    private static List<String> findSubstr(String word) {
        List<String> all = new ArrayList<>();
        List<String> last = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            last.add(word.substring(0, i+1));
        }

        all.addAll(last);

        while (last.size() > 0) {
            List<String> newSet = new ArrayList<>();

            for (String s : last) {
                if (s.length() > 1) {
                    newSet.add(s.substring(1, s.length()));
                }
            }

            all.addAll(newSet);
            last = newSet;
        }

        return all;
    }

    private static List<String> palindromes(String word) {
        List<String> substrs = findSubstr(word);

        List<String> pals = new ArrayList<>();
        for (String s : substrs) {
            if (isPalindrome(s)) {
                pals.add(s);
            }
        }

        return pals;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
