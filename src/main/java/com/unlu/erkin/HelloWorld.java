package com.unlu.erkin;

/**
 * Created by ERKIN on 24/12/14.
 */
public class HelloWorld {

    public static void main(String[] args) {
        int n = 5;
        System.out.println("I am now: " + n);
        printMe(++n);
    }

    public static void printMe(int n) {
        System.out.println("i am printing you: " + n);
    }
}
