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
}
