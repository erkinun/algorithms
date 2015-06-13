package com.unlu.erkin.functional;

import javaslang.collection.List;
import javaslang.control.Try;

import java.util.function.Function;

/**
 * Created by ERKIN on 13/06/15.
 */
public class Lambdas {

    private static Function<Integer, Character> i2Char = integer -> {
        char c = '0';

        while (integer > 0) {
            c++;
            integer--;
        }

        return c;
    };

    private static Function<Integer, String> i2Str = integer -> {
        if (integer < 0) {
            integer = Math.abs(integer);
        }

        StringBuilder builder = new StringBuilder();
        while (integer > 0) {
            int rem = integer % 10;
            integer /= 10;
            builder.insert(0, i2Char.apply(rem));
        }

        return builder.toString();
    };

    private static TriFunction<Integer, Integer, Integer, Integer> threeSum = (integer, integer2, integer3) -> {
        return integer + integer2 + integer3;
    };

    public static void main(String[] args) {
        System.out.println(i2Str.apply(95));
        System.out.println(threeSum.apply(1, 2, 3));

        List<Integer> slangList = List.of(1,2,3);
        List<Integer> imp = slangList.map(inte -> ++inte);

        imp.forEach(System.out::println);
    }
}
