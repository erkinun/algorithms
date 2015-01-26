package com.unlu.erkin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeImplTest {

    private TreeImpl<Character> tree;
    private TreeImpl.Node<Character> root;

    @Before
    public void setup() {
        tree = new TreeImpl<Character>('A');

        root = new TreeImpl.Node<Character>('A');
        TreeImpl.Node<Character> left = new TreeImpl.Node<Character>('B');
        TreeImpl.Node<Character> r1 = new TreeImpl.Node<Character>('C');
        TreeImpl.Node<Character> r1l1 = new TreeImpl.Node<Character>('D');
        TreeImpl.Node<Character> r1r2 = new TreeImpl.Node<Character>('E');
        r1.setLeft(r1l1);
        r1.setRight(r1r2);
        root.setLeft(left);
        root.setRight(r1);
    }

    @Test
    public void testPreorderTraversal() throws Exception {
        tree.preorderTraversal(root);
    }

    @Test
    public void testPreorderWithoutRec() throws Exception {
        tree.preOrderWithoutRecursion(root);
    }
}