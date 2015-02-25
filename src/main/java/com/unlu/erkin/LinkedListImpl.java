package com.unlu.erkin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by ERKIN on 25/01/15.
 */
public class LinkedListImpl<T> {

    public static void main(String[] args) {
        Node node = new Node(5);
        node.append(4);
        node.append(4);
        node.append(3);
        node.append(3);

        node.print();

        Node newHead = removeDups(node);

        newHead.print();
    }

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
        Node child;
        T val;

        public Node(){}

        public Node(T val) {
            this.val = val;
        }

        public void append(T val) {
            Node cur = this;
            while (cur.next != null) {
                cur = cur.next;
            }

            cur.next = new Node(val);
        }

        public void print() {
            StringBuilder builder = new StringBuilder();

            Node cur = this;
            while (cur != null) {
                builder.append(",node: " + cur.val);
                cur = cur.next;
            }

            System.out.println(builder.toString());
        }
    }

    private static Node removeDups(Node head) {
        Node cur = head;
        Set set = new HashSet<>();

        while (cur.next != null) {
            set.add(cur.val);
            cur = cur.next;
        }

        Node newHead = new Node();
        int i = 0;
        for (Object obj : set) {

            if (i == 0) {
                newHead.val = obj;
            }
            else {
                newHead.append(obj);
            }
            i++;
        }

        return newHead;
    }
}
