package com.unlu.erkin;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ERKIN on 11/03/15.
 */
public class Regex {

    public static void main(String[] args) {
        String sentence = "Hey! I am trying to be a person here! You know; it's hard?";

        String[] words = sentence.split("\\W");


        System.out.println(Arrays.toString(words));

        words = sentence.split("\\s+");

        System.out.println(Arrays.toString(words));

        words = sentence.split("\\W*\\s");

        System.out.println(Arrays.toString(words));

        String paragraph = "In terms of mathematical optimization, dynamic programming usually refers to simplifying a decision by breaking it down into a sequence of decision steps over time. This is done by defining a sequence of value functions V1, V2, ..., Vn, with an argument y representing the state of the system at times i from 1 to n. The definition of Vn(y) is the value obtained in state y at the last time n. The values Vi at earlier times i = n −1, n − 2, ..., 2, 1 can be found by working backwards, using a recursive relationship called the Bellman equation. For i = 2, ..., n, Vi−1 at any state y is calculated from Vi by maximizing a simple function (usually the sum) of the gain from a decision at time i − 1 and the function Vi at the new state of the system if this decision is made. Since Vi has already been calculated for the needed states, the above operation yields Vi−1 for those states. Finally, V1 at the initial state of the system is the value of the optimal solution. The optimal values of the decision variables can be recovered, one by one, by tracking back the calculations already performed.";

        Pattern pattern = Pattern.compile("\\w[0-9]");

        Matcher matcher = pattern.matcher(paragraph);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        String nameAndMail = "erkin, erkinun at gmail dot com";

        pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
        pattern.matcher(nameAndMail);

        while (matcher.find()) {
            System.out.println(matcher
                    .group());
        }

        String forever = "for3v3r";

        pattern = Pattern.compile("[0-9]+");
        matcher = pattern.matcher(forever);


        System.out.println(forever.matches("\\d+"));

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        String username = "#erkin_'23";
        String usernameRegex = "[a-zA-Z0-9_-]{3,16}]";

        System.out.println(username.matches(usernameRegex));

        pattern = Pattern.compile(usernameRegex);
        matcher = pattern.matcher("erk");

        System.out.println(matcher.find());

        System.out.printf("%x", 1986 );

        /**
         * try (Writer writer = new BufferedWriter(new OutputStreamWriter(
         new FileOutputStream("filename.txt"), "utf-8"))) {
         writer.write("something");
         }
         */
    }
}
