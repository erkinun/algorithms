package com.unlu.erkin.lists;

/**
 * Created by ERKIN on 05/05/15.
 */
public class SortedList {

    public static void main(String[] args) {
        Node<Integer> head;

        head = insert(null, 5);

        head.print();

        head = insert(head, 3);
        head = insert(head, 1);

        head.print();

        head = insert(head, 2);
        head.print();

        head = insert(head, 4);
        head.print();
    }

    private static Node<Integer> insert(Node<Integer> head, int val) {
        if (head == null) {
            Node hd = new Node<Integer>(val);
            return hd;
        }

        Node<Integer> current = head;
        Node<Integer> prev = null;

        while (current.next != null && val < current.val) {
            prev = current;
            current = current.next;
        }

        if (val > current.val) {
            Node nd = new Node<Integer>(val);
            nd.next = current;
            if (prev != null) {
                prev.next = nd;
            }
        }
        else {
            current.next = new Node(val);
        }

        return head;
    }
}
