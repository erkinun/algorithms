package com.unlu.erkin.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceLane {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        int[] widths = new int[scanner.nextInt()];

        int testCases = scanner.nextInt();

        for (int i = 0; i < widths.length; i++) {
            widths[i] = scanner.nextInt();
        }

        List<Case> caselist = new ArrayList<>();
        for (int i = 0; i < testCases; i++) {
            Case cse = new Case(scanner.nextInt(), scanner.nextInt());
            caselist.add(cse);
        }

        caselist.stream().forEach( cse -> {
            System.out.println(cse.findMin(widths));
        });
    }

    private static class Case {
        public int entry;
        public int exit;

        public Case(int en, int ex) {
            entry = en;
            exit = ex;
        }

        public int findMin(int[] width) {
            int min = Integer.MAX_VALUE;
            for (int i = entry; i <= exit; i++) {
                if (width[i] < min) {
                    min = width[i];
                }
            }

            return min;
        }
    }
}