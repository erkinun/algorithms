package com.unlu.erkin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ERKIN on 19/05/15.
 */

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] chars = word.toCharArray();

        TrieNode current = root;
        for (Character c : chars) {
            boolean found = false;
            for (TrieNode child : current.getChildren()) {
                if (child.getKey() == c) {
                    current = child;
                    found = true;
                    break;
                }
            }
            if (!found) {
                //insert a new trienode
                TrieNode newNode = new TrieNode(c);
                current.getChildren().add(newNode);
                current = newNode;
            }
        }

        current.setWordFinished();

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] chars = word.toCharArray();

        TrieNode current = root;
        for (Character c : chars) {
            boolean charFound = false;
            for (TrieNode child : current.getChildren()) {
                if (child.getKey() == c) {
                    charFound = true;
                    current = child;
                    break;
                }
            }
            if (!charFound) {
                return false;
            }
        }


        return current.isWord();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();

        TrieNode current = root;
        for (Character c : chars) {
            boolean charFound = false;
            for (TrieNode child : current.getChildren()) {
                if (child.getKey() == c) {
                    charFound = true;
                    current = child;
                    break;
                }
            }
            if (!charFound) {
                return false;
            }
        }


        return true;
    }

    static class TrieNode {
        // Initialize your data structure here.
        private char key;
        private List<TrieNode> children = new ArrayList<TrieNode>();
        private boolean wordFinished = false;

        public TrieNode() {
            //key = '';
        }

        public TrieNode(char c) {
            key = c;
        }

        public char getKey() {
            return key;
        }

        public List<TrieNode> getChildren() {
            return children;
        }

        public void setWordFinished() {
            wordFinished = true;
        }

        public boolean isWord() {
            return wordFinished;
        }
    }
}