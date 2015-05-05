package com.unlu.erkin.lists;

/**
 * Created by ERKIN on 05/05/15.
 */
public class Node<T> {
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

    public void append(Node node) {
        Node cur = this;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = node;
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        Node cur = this;
        while (cur != null && cur.val != null) {
            builder.append(cur.val + ", ");
            cur = cur.next;
        }

        builder.append("]");

        System.out.println(builder.toString());
    }
}
