package com.unlu.erkin;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ERKIN on 15/02/15.
 */
public class PhoneQuestions {

    public static void main(String[] args) throws IOException {
        System.out.println(fibNth(5));

        printMultiplicationTable(12);

        frequency("anne");

        merge(new int[]{10,5,4,1}, new int[]{9,8,7,5,0});

        //printToFile();

        System.out.println(findLonelyInteger(new int[] {1,3,2,3,2}));

        int[] a = new int[5];
        a[0] = 4;
        a[1] = 5;
        a[2] = 6;

        int[] b = new int[] {1,2};
        merge(a, b, 2, 1);

//        System.out.println(Arrays.toString(a));

        int[] c = new int[] {-4, 2, 100};

        System.out.println(Arrays.toString(mergeShort(c, b)));

        System.out.println(Arrays.toString(mergeSort(new int[] {100, 5,1, 10024, -5})));
    }

    public static int fibNth(int n) {
        if (n == 1 || n == 0) { return 1; }

        return fibNth(n - 1) + fibNth(n - 2);
    }

    public static void printMultiplicationTable(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print((i*j) + " ");
            }
            System.out.println();
        }
    }

    public static void frequency(String word) {
        char[] wordA = word.toCharArray();

        short[] freqs = new short[256]; //for ascii

        for (int i = 0; i < wordA.length; i++) {
            freqs[wordA[i]] += 1;
        }

        for (short i = 0; i < freqs.length; i++) {
            if (freqs[i] > 0) {
                System.out.println("char " + (char)i + ": has freqs: " + freqs[i]);
            }
        }
    }

    public static void merge(int[] first, int[] second) {

        int t = 0;
        int i = 0;
        int j = 0;

        int[] third = new int[first.length + second.length];
        while (i < first.length && j < second.length) {
            if (first[i] >= second[j]) {
                third[t] = first[i++];
            }
            else {
                third[t] = second[j++];
            }
            t++;
        }

        if (i != first.length) {
            for (; i < first.length; i++, t++) {
                third[t] = first[i];
            }
        }

        if (j != second.length) {
            for (; j < second.length; j++, t++) {
                third[t] = second[j];
            }
        }

        for (int ind = 0; ind < third.length; ind++) {
            System.out.print(third[ind] + " ");
        }
        System.out.println();
    }

    private static void printToFile() throws IOException {
        String hede = "hede";
        Scanner scanner = new Scanner(new FileReader("/Users/ERKIN/temp/hede.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/ERKIN/temp/hodo.txt"));
        while (scanner.hasNext()) {
            writer.write(scanner.next());
        }

        scanner.close();
        writer.close();
    }

    private static Integer[][] commonsAndDifferences(int[] first, int[] second) {
        Integer[][] sets = new Integer[3][];

        Set<Integer> firstSet = new HashSet<>();
        for (Integer i : first) {
            firstSet.add(i);
        }

        Set<Integer> secondSet = new HashSet<>();
        for (Integer i : second) {
            secondSet.add(i);
        }

        Set<Integer> thirdSet = new HashSet<>();
        firstSet.stream().filter(i -> secondSet.contains(i)).forEach(i -> {
            firstSet.remove(i);
            secondSet.remove(i);
            thirdSet.add(i);
        });

        sets[1] = (Integer[])firstSet.toArray();
        sets[2] = (Integer[])secondSet.toArray();
        sets[3] = (Integer[])thirdSet.toArray();

        return sets;
    }

    private static int findLonelyInteger(int[] array) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int[] vals = new int[max + 1];

        for (int i = 0; i < array.length; i++) {
            vals[array[i]] ^= array[i];
        }

        for (int i = 0; i < array.length; i++) {
            if (vals[i] != 0) {
                return i;
            }
        }

        return -1;
    }

    private static void merge(int[] a, int[] b, int m, int n) {
        //a => 4,5,6,_,_
        //b => 1,2

        int k = m + n + 1;

        while (m >= 0 && n >= 0) {
            if (a[m] >= b[n]) {
                a[k--] = a[m--];
            }
            else {
                a[k--] = b[n--];
            }
        }

        if (m < 0) {
            //A is finished
            while (n >= 0) {
                a[k--] = b[n--];
            }
        }
    }

    private static int[] mergeShort(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];

        int i = 0, j = 0, m = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                merged[m++] = a[i++];
            }
            else {
                merged[m++] = b[j++];
            }
        }

        while (i < a.length) {
            merged[m++] = a[i++];
        }
        while (j < b.length) {
            merged[m++] = b[j++];
        }

        return merged;
    }

    private static int[] mergeSort(int[] a) {
        if (a.length == 1 || a.length == 0) {
            return a;
        }

        int[] left = Arrays.copyOfRange(a, 0, a.length / 2);
        int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return mergeShort(left, right);
    }
}
