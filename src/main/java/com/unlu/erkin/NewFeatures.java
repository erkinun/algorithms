package com.unlu.erkin;

import java.util.Optional;

/**
 * Created by ERKIN on 15/03/15.
 */
public class NewFeatures {

    public static void main(String[] args) {

        Optional val = Optional.ofNullable(null);

        System.out.println(val.orElse("I am else and empty"));
    }
}
