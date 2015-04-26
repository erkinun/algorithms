package com.unlu.erkin.oop;

/**
 * Created by ERKIN on 26/04/15.
 */
public class SampleSub extends BaseAbstract {

    public static String sayHede() {
        return "im concrete";
    }

    private String hede() {
        return "subclass";
    }

    @Override
    public String sayHello() {
        return hede();
    }


}
