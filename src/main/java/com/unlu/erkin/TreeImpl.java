package com.unlu.erkin;


/**
 * Created by ERKIN on 25/12/14.
 */

import java.util.Stack;

/**
 * Binary Tree Implementation
 */
public class TreeImpl<T> {

    private Node<T> root;

    TreeImpl(T val) {
        root = new Node<T>(val);
    }

    public static void main(String[] args) {
        int[] sorted = new int[] {1,2,3,4,5,6};

        Node root = convert(sorted, 0, 5);

        preorderTraversal(root);
    }

    public static void preorderTraversal(Node node) {

        if (node == null) {
            return;
        }

        System.out.println(node.value);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public static void preOrderWithoutRecursion(Node node) {

        if (node == null) {
            return;
        }

        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(node);

        while (nodeStack.size() > 0) {
            Node cur = nodeStack.pop();
            if (cur == null) {
                continue;
            }
            System.out.println(cur.value);
            nodeStack.push(cur.right);
            nodeStack.push(cur.left);
        }
    }

    public static class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

    public static int countInRange(Node<Integer> root, int min, int max) {
        if (root == null) {return 0;}

        int count = 0;
        if (min <= root.value && max >= root.value) {
            count++;
        }

        count += countInRange(root.left, min, max);
        count += countInRange(root.right, min, max);

        return count;
    }

    private static Node convert(int[] array, int start, int end) {

        if (array.length == 0 || start > end) { return null; }

        int mid = (end - start)/2 + start;

        Node node = new Node(array[mid]);
        node.value = array[mid];

        if (start == end) { return node; }


        node.left = convert(array, start, mid-1);
        node.right = convert(array, mid+1, end);

        return node;
    }
}
