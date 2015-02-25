package com.unlu.erkin;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

        printToFile();
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
}
