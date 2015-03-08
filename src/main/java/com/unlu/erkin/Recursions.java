package com.unlu.erkin;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ERKIN on 29/01/15.
 */
public class Recursions {

    public static void main(String[] args) {

        int[] sorted = new int[] {1,2,3,4,5};

        binarySearch(sorted, 1);
        binarySearch(sorted, 4);
        binarySearch(sorted, 7);

        perms("", "hat");

        Set<String> combsEmpty = new HashSet<>();
        combsEmpty.add("");
        Set<String> combs = combs("wxyz", 0, combsEmpty);

        combs.stream()
                .sorted()
                .forEach(comb -> System.out.println(comb));
    }

    private static void binarySearch(int[] sorted, int num) {
        int start = 0;
        int end = sorted.length - 1;

        innerBinary(sorted, num, start, end);
    }

    private static void innerBinary(int[] sorted, int num, int start, int end) {
        int index = ((end - start) / 2) + start;

        if (index < 0 || index >= sorted.length) {
            System.out.println("not found!");
            return;
        }

        if (num == sorted[index]) {
            System.out.println("found it at index: " + index);
        }
        else if (num < sorted[index]) {
            innerBinary(sorted, num, start, index-1);
        }
        else {
            innerBinary(sorted, num, index+1, end);
        }
    }

    private static void perms(String perm, String word) {
        if (word == null || word.length() == 0) {
            System.out.println(perm);
            return;
        }

        int i = 0;
        for (Character c : word.toCharArray()) {
            StringBuilder builder = new StringBuilder(word);
            perms(perm + c, builder.deleteCharAt(i).toString());
            i++;
        }
    }

    private static Set<String> combs(String word, int index, Set<String> combs) {
        if (index >= word.length()) {
            return combs;
        }

        char c = word.charAt(index);

        Set<String> newSet = new HashSet<>();
        for (String comb : combs) {
            newSet.add(comb + c);
            newSet.add(comb);
        }

        return combs (word, index+1, newSet);
    }
}
