package com.unlu.erkin.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ERKIN on 19/05/15.
 */
public class TrieTest {

    private Trie trie = new Trie();

    @Test
    public void testOneChar() throws Exception {
        trie.insert("a");

        assertTrue(trie.search("a"));
    }

    @Test
    public void testSearch() throws Exception {
        trie.insert("erkin");

        assertTrue(trie.search("erkin"));
    }

    @Test
    public void testNotFound() throws Exception {
        trie.insert("hede");

        assertFalse(trie.search("hodo"));
    }

    @Test
    public void testSearchIncludesButNotFound() {
        trie.insert("hat");
        assertFalse(trie.search("ha"));
    }

    @Test
    public void testPrefixFinds() {
        trie.insert("hat");
        assertTrue(trie.startsWith("ha"));
    }
}