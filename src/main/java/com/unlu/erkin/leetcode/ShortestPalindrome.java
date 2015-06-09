package com.unlu.erkin.leetcode;

/**
 * Created by ERKIN on 09/06/15.
 */
public class ShortestPalindrome {

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("abcd"));
    }

    public static String shortestPalindrome(String s) {
        StringBuilder builder = new StringBuilder(s);
        char[] strA = s.toCharArray();

        for (int i = builder.length() - 1; i >= builder.length() / 2; i--) {
            char temp = builder.charAt(i);
            int offSet = builder.length() - i - 1;
            if (temp != builder.charAt(offSet)) {
                builder.insert(offSet, temp);
                i++;
            }
        }

        return builder.toString();
    }
}
