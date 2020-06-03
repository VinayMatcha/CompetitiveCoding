package com.vinay.trees;


import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<Key extends Comparable<Key>, Value>{
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int count;

        public Node(Key key, Value val) {
            this.key = key;
            this.value = val;
            this.count = 1;
        }

    }

    private Node root;

    public void put(Key key, Value val) {
        root = put(key, val, root);
    }

    private Node put(Key key, Value val, Node node) {
        if (node == null)
            return new Node(key, val);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(key, val, node.left);
        } else if (cmp > 0) {
            node.right = put(key, val, node.right);
        } else {
            node.value = val;
        }
        node.count =  1 + size(node.left) + size(node.right);
        return node;
    }

    public Value get(Key key) {
        Node checkNode = root;
        while (checkNode != null) {
            int cmp = key.compareTo(checkNode.key);
            if (cmp < 0) {
                checkNode = checkNode.left;
            } else if (cmp > 0) {
                checkNode = checkNode.right;
            } else {
                return checkNode.value;
            }
        }
        return null;
    }

    public void delete(Key key) {
        root = delete(key, root);
    }

    private Node delete(Key key, Node node) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(key, node.left);
        } else if (cmp > 0) {
            node.right = delete(key, node.right);
        } else {
            // no right child
            if (node.right == null)
                return node.left;
            Node temp = node;
            //search for succesor
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }


    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    private Node min(Node node) {
        if (node == null)
            return null;
        Node temp = min(node.left);
        if (temp != null)
            return temp;
        return node;
    }

    public Key floor(Key key) {
        Node result = floor(key, root);
        if (result == null)
            return null;
        return result.key;
    }

    private Node floor(Key key, Node node) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return floor(key, node.left);
        } else if (cmp > 0) {
            Node temp = floor(key, node.right);
            if (temp != null)
                return temp;
            return node;
        } else {
            return node;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        return node.count;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node node) {
        if (node == null)
            return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return rank(key, node.left);
        } else if (cmp > 0) {
            return 1 + size(node.left) + rank(key, node.right);
        } else {
            return size(node.left);
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node node, Queue<Key> queue) {
        if (node == null)
            return;
        inorder(node.left, queue);
        queue.add(node.key);
        inorder(node.right, queue);
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put("hello", 1);
        System.out.println(binarySearchTree.get("hello"));
    }


}


