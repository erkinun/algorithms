package com.unlu.erkin;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.unlu.erkin.LinkedListImpl.Node;

import static com.unlu.erkin.LinkedListImpl.findCyclicNode;
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

    @Test
    public void testNode2Int() throws Exception {
        Node head = new Node(1);
        head.append(2);
        head.append(3);

        Method toInt = LinkedListImpl.class.getDeclaredMethod("toInt", Node.class);
        toInt.setAccessible(true);
        int result = (Integer) toInt.invoke(null, head);

        assertEquals(321, result);

    }

    @Test
    public void testInt2Node() throws Exception {
        Method toNode = LinkedListImpl.class.getDeclaredMethod("toNode", int.class);
        toNode.setAccessible(true);

        Node head = (Node) toNode.invoke(null, 456);

        assertNotNull(head);

        head.print();
    }

    @Test
    public void test2NodeAdd() throws Exception {
        Node head = new Node(1);
        head.append(2);
        head.append(3);

        Node head2 = new Node(0);
        head2.append(0);
        head2.append(2);

        Node res = LinkedListImpl.addListsAsIntS(head, head2);

        assertNotNull(res);

        res.print();
    }

    @Test
    public void testCyclicNode() throws Exception {
        Node head = new Node('A');
        head.append('B');
        Node cyclic = new Node('C');
        head.append(cyclic);
        head.append('D');
        head.append('E');
        head.append(cyclic);


        Node res = findCyclicNode(head);

        assertEquals(res, cyclic);
    }

}