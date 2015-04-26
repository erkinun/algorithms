package com.unlu.erkin;


/**
 * Created by ERKIN on 25/12/14.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Binary Tree Implementation
 */
public class TreeImpl<T extends Comparable> {

    private Node<T> root;

    TreeImpl(T val) {
        root = new Node<T>(val);
    }

    public static void main(String[] args) {
        //int[] sorted = new int[] {1,2,3,4,5,6};

        //Node root = convert(sorted, 0, 5);

        //preorderTraversal(root);


        Node root = new Node(10);
        insert(root, 12);
        insert(root, 7);
        insert(root, 11);
        insert(root, 9);
        insert(root, 1);
        insert(root, 5);
        insert(root, 4);

        breadthFirstTraversal(root);
        System.out.println();

        printInOrder(root);

        System.out.println(isBalanced(root));

        insert(root, 13);
        insert(root, 14);

        System.out.println(isBalanced(root));

        List<List<Node>> treeAsList = listsOfTree(root);

        for (List<Node> nodes : treeAsList) {
            for (Node nd : nodes) {
                System.out.print(nd.value + ",");
            }
            System.out.println();
        }

        Node n1 = new Node(10);
        System.out.println(isSameTree(root, n1));
        System.out.println(isSameTree(root, root));
    }

    public static void preorderTraversal(Node node) {

        if (node == null) {
            return;
        }

        System.out.println(node.value);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public static void breadthFirstTraversal(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(node);
        int childCount = 0;
        int elem = 1;

        while (!nodes.isEmpty()) {
            Node cur = nodes.remove();
            elem -= 1;
            if (cur.left != null) {
                nodes.add(cur.left);
                childCount += 1;
            }
            if (cur.right != null) {
                nodes.add(cur.right);
                childCount += 1;
            }

            System.out.print(cur.value + " ");

            if (elem == 0) {
                System.out.println();
                elem = childCount;
                childCount = 0;
            }
        }
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

    public static class Node<T extends Comparable> {
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

    private static int depth(Node root, int curDepth) {
        if (root == null) { return curDepth - 1; }

        if (root.left == null && root.right == null) { return curDepth; }

        int left = depth(root.left, curDepth+1);
        int right = depth(root.right, curDepth+1);

        if (left >= right) { return left; }
        else { return right; }
    }

    public static Node insert(Node node, Comparable val) {

        if (node == null) {
            node = new Node(val);
            return node;
        }

        if (node.value.compareTo(val) == 0) { return node; }
        else if (node.value.compareTo(val) < 0) {
            node.right = insert(node.right, val);
        }
        else {
            node.left = insert(node.left, val);
        }

        return node;
    }

    public static boolean isBalanced(Node root) {
        if (root == null) {
            return false;
        }

        int left = depth(root.left, 1);
        int right = depth(root.right, 1);

        return Math.abs(left - right) <= 1;
    }

    public static List<List<Node>> listsOfTree(Node node) {

        if (node == null) {
            throw new NullPointerException("tree null!");
        }

        List<List<Node>> listOfLists = new ArrayList<>();

        int elem = 1;
        int childCount = 0;

        List<Node> curList = new ArrayList<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);

        while (elem > 0) {
            Node nd = nodeQueue.remove();
            elem--;

            if (nd.left != null) {
                nodeQueue.add(nd.left);
                childCount++;
            }
            if (nd.right != null) {
                nodeQueue.add(nd.right);
                childCount++;
            }

            curList.add(nd);

            if (elem == 0) {
                elem = childCount;
                childCount = 0;
                listOfLists.add(curList);
                curList = new ArrayList<>();
            }
        }
        return listOfLists;
    }

    public static boolean isSameTree(Node n1, Node n2) {

        if (n1 == null && n2 == null) {
            return true;
        }

        if (n1 == null || n2 == null) {
            return false;
        }

        if (!n1.value.equals(n2.value)) {
            return false;
        }


        return isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
    }

    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.println(root.value);
        printInOrder(root.right);
    }
}
