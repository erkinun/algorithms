package com.unlu.erkin;

import java.io.File;
import java.io.FileNotFoundException;
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
    }

    private static String randomMail(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));

        List<String> mails = new ArrayList<>();
        while (scanner.hasNext()) {
            mails.add(scanner.next());
        }

        int length = mails.size();
        Random random = new Random();

        int index = random.nextInt() % length;

        return mails.get(index);
    }
}
