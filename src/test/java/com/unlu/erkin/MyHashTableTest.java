package com.unlu.erkin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashTableTest {

    private MyHashTable myHashTable;

    @Before
    public void setUp() throws Exception {
        myHashTable = new MyHashTable();
    }

    @Test
    public void testAdd() throws Exception {
        Integer five = new Integer(5);
        myHashTable.add(five);

        Integer isFive = (Integer)myHashTable.get(five);

        assertSame(five, isFive);
    }

    @Test
    public void testGet() throws Exception {

    }
}