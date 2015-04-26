package com.unlu.erkin.oop;

/**
 * Created by ERKIN on 26/04/15.
 */
public interface SampleInterface {

    String name = "interface";

    public default String sayInterface() {
        return name;
    }
}
