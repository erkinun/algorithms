package com.unlu.erkin.hackerrank;

import java.util.Scanner;

/**
 * Created by ERKIN on 26/04/15.
 */

public class AngryProfessor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        int studentCount;
        int minRequired;
        for (int i = 0; i < testCases; i++) {
            studentCount = scanner.nextInt();
            minRequired = scanner.nextInt();

            int arrival;
            int onTimes = 0;
            for (int j = 0; j < studentCount; j++) {
                arrival = scanner.nextInt();
                if (arrival <= 0) {
                    onTimes++;
                }
            }

            if (onTimes >= minRequired) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
    }
}
