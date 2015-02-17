package com.unlu.erkin;

/**
 * Created by ERKIN on 15/02/15.
 */
public class MyHashTable {

    private volatile int length = 100;
    private int load = 0;

    private Object[] table = new Object[length];

    public synchronized void add(Object item) {
        table[item.hashCode() % length] = item;
        load++;
    }

    public synchronized Object get(Object item) {
        return table[item.hashCode() % length];
    }
}
