package com.unlu.erkin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ERKIN on 25/01/15.
 */
public class LinkedListImpl<T> {

    public List<T> flatten (Node<T> head) {
        //if has a child go a process
        //get to next

        List<T> acc = new ArrayList<T>();
        Node current = head;

        while (current != null) {
            System.out.println("adding current val");
            acc.add((T) current.val);

            if (current.child != null) {
                System.out.println("adding child values");
                acc.addAll(flatten(current.child));
            }

            System.out.println("switching to next");
            current = current.next;
        }

        return acc;

    }

    public static class Node<T> {
        Node next;
        Node prev;
        Node child;
        T val;
    }
}
