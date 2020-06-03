package com.vinay.tries;

import java.util.HashMap;

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert (String word) {
        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(ch, k -> new TrieNode());
        }
        current.setEnd(true);
    }

    public boolean find (String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.getChildren().get(ch);
            if (current == null)
                return false;
        }
        return current.isEnd();
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode node, String word, int index) {
        if (index == word.length()) {
            if (node.isEnd())
                return false;
            node.setEnd(false);
            return node.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode child = node.getChildren().get(ch);
        if (child == null)
            return false;
        boolean shouldDeleteChildNode = delete(child, word, index+1) && !node.isEnd();
        if (shouldDeleteChildNode) {
            node.getChildren().remove(ch);
            return node.getChildren().isEmpty();
        }
        return false;
    }

}
