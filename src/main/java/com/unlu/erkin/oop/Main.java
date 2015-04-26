package com.unlu.erkin.oop;

/**
 * Created by ERKIN on 26/04/15.
 */
public class Main {

    public static void main(String[] args) {
        BaseAbstract obj = new SampleSub();

        System.out.println(obj.sayHello());
        System.out.println(BaseAbstract.sayHede());
        System.out.println(SampleSub.sayHede());

        SampleInterface sampleInterface = new SampleInterface() {};
        System.out.println(sampleInterface.sayInterface());
    }
}
