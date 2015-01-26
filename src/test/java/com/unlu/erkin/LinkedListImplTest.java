package com.unlu.erkin;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LinkedListImplTest {

    private LinkedListImpl.Node<Integer> linkedList;

    @Before
    public void setUp() {
        linkedList = new LinkedListImpl.Node<Integer>();
        linkedList.val = 5;

        LinkedListImpl.Node<Integer> second = new LinkedListImpl.Node<Integer>();
        second.val = 4;
        LinkedListImpl.Node<Integer> secondChild = new LinkedListImpl.Node<Integer>();
        secondChild.val = 3;
        second.child = secondChild;
        linkedList.next = second;


        LinkedListImpl.Node<Integer> third = new LinkedListImpl.Node<Integer>();
        third.val = 2;
        second.next = third;
    }

    @Test
    public void testFlatten() throws Exception {
        LinkedListImpl<Integer> test = new LinkedListImpl<Integer>();
        List<Integer> result = test.flatten(linkedList);

        System.out.println("resulting lists size: " + result.size());

        assertTrue(result.size() == 4);
    }
}