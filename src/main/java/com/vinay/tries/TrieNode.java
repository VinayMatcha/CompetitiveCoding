package com.vinay.tries;

import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isEnd;
    private String content;

    public TrieNode() {
        children = new HashMap<>();
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}