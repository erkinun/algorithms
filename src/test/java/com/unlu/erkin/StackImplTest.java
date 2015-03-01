package com.unlu.erkin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackImplTest {

    private StackImpl<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new StackImpl<Integer>();
    }

    @Test
    public void testPush() throws Exception {
        stack.push(0);
        stack.push(1);
        stack.push(2);

        assertTrue(2 == stack.pop());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPop() throws Exception {
        stack.pop();
    }

    @Test
    public void testDelete() throws Exception {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertTrue(stack.delete(2));
    }

    @Test
    public void testInsertAfter() throws Exception {
        stack.push(1);
        stack.push(2);
        stack.push(3);

    }

    @Test
    public void testMin() throws Exception {
        stack.push(3);
        stack.push(2);

        assertEquals(2, (int)stack.getMin());

        stack.push(1);
        stack.push(0);

        assertEquals(0, (int)stack.getMin());

        stack.pop();

        assertEquals(1, (int)stack.getMin());
    }
}