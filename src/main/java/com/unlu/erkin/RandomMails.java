package com.unlu.erkin;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by ERKIN on 05/04/15.
 */
public class RandomMails {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(RandomMails.randomMail("files/emails.txt"));

        System.out.println("rand: " + generateBetween(0,100));
        System.out.println("rand2: " + generateBetween(0, 100));

        System.out.println(-11 % 2);
    }

    private static String randomMail(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));

        List<String> mails = new ArrayList<>();
        while (scanner.hasNext()) {
            mails.add(scanner.next());
        }

        int length = mails.size();
        Random random = new Random();

        int index = Math.abs(random.nextInt()) % length;

        return mails.get(index);
    }

    private static int generateBetween(int start, int end) {

        if (start >= end) {
            throw new IllegalArgumentException("start must be smaller than end");
        }

        SecureRandom random = new SecureRandom();

        int interval = end - start;
        int gen = Math.abs(random.nextInt() % interval) + start;

        return gen;
    }
}
