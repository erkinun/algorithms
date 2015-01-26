package com.unlu.erkin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CyclicListFinderTest {

    private CyclicListFinder finder = new CyclicListFinder();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testIsCyclic() throws Exception {
        CyclicListFinder.Node first = new CyclicListFinder.Node();
        first.val = 5;
        CyclicListFinder.Node second = new CyclicListFinder.Node();
        second.val = 4;
        first.next = second;
        second.next = null;

        assertTrue(finder.isAcyclic(first));
    }

    @Test
    public void testIsCyclicFalse() throws Exception {
        CyclicListFinder.Node first = new CyclicListFinder.Node();
        first.val = 5;
        CyclicListFinder.Node second = new CyclicListFinder.Node();
        second.val = 4;
        CyclicListFinder.Node third = new CyclicListFinder.Node();
        third.val = 3;
        third.next = first;
        first.next = second;
        second.next = third;

        assertFalse(finder.isAcyclic(first));
    }
}