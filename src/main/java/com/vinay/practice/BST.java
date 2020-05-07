package com.vinay.practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    public BST() {
        root = null;
    }

    private class Node{
        private Key key;
        private Value value;
        private Node left, right;
        private int count;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public Iterator<Key> keys(){
        Queue<Key> queue = new LinkedList<>();
        inorder(root, queue);
        return (Iterator<Key>) queue;
    }

    private void inorder(Node x, Queue<Key> queue) {
        if(x == null){
            return;
        }
        inorder(x.left, queue);
        queue.add(x.key);
        inorder(x.right, queue);
    }


    public int size(){
        return size(root);
    }

    private int size(Node x) {
        if(x == null){
            return 0;
        }
        return x.count;
    }

    public BST(Node root) {
        this.root = root;
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public Value getKey(Key key){
        Node check = root;
        while(check != null){
            int cmp = key.compareTo(check.key);
            if(cmp < 0){
                check = check.left;
            }else if(cmp > 0){
                check = check.right;
            }else{
                return check.value;
            }
        }
        return null;
    }
    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if(x ==  null){
            return new Node(key, value);
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = put(x.left, key, value);
        }else if(cmp > 0){
            x.right = put(x.right, key, value);
        }else{
            x.value = value;
        }
        x.count = 1 + size(x.right) + size(x.left);
        return x;
    }

    private void putDirect(Key key, Value value){
        if(root == null){
            root = new Node(key, value);
        }
        Node check = root;
        Node parent = null;
        while(check != null){
            parent = check;
            int cmp = key.compareTo(check.key);
            if(cmp < 0){
                check = check.left;
            }else if(cmp > 0){
                check = check.right;
            }else {
                check.value = value;
                break;
            }
        }
        if(check == null){
            int cmp = key.compareTo(parent.key);
            if(cmp < 0){
                parent.left = new Node(key, value);
            }else{
                parent.right = new Node(key, value);
            }
        }
    }


    private Key floor(Key key){
        Node x = floor(root, key);
        if(x == null){
            return null;
        }else {
            return x.key;
        }
    }

    private Node floor(Node x, Key key) {
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            return floor(x.left, key);
        }else if(cmp == 0){
            return x;
        }
        Node t = floor(x.right, key);
        if(t != null){
            return t;
        }else{
            return x;
        }
    }


    private Key ceil(Key key){
        Node x = ceil(root, key);
        if(x == null){
            return null;
        }else {
            return x.key;
        }
    }

    private Node ceil(Node x, Key key) {
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp > 0){
            ceil(x.right, key);
        }else if(cmp == 0){
            return x;
        }
        Node t = floor(x.left, key);
        if(t != null){
            return t;
        }else {
            return x;
        }
    }


    public static void main(String[] args) {
        BST<String, String> st = new BST<>();

        // insert some (key, value pairs)
        st.put("www.cs.princeton.edu", "128.112.136.12");
        st.put("www.cs.princeton.edu", "128.112.136.11");
        st.put("www.princeton.edu",    "128.112.128.15");
        st.put("www.yale.edu",         "130.132.143.21");
        st.put("www.amazon.com",       "208.216.181.15");
        st.put("www.simpsons.com",     "209.052.165.60");

        // search for IP addresses given URL
        System.out.println(st.getKey("www.cs.princeton.edu"));
        System.out.println(st.getKey("www.amazon.com"));
        System.out.println(st.getKey("www.amazon.edu"));

        System.out.println(st);
    }



}
