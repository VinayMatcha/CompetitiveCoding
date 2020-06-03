package com.vinay.trees;

public class AVLTree<Key extends Comparable<Key>> {

    private Node root;

    private class Node {
        private Key key;
        private Node right, left;
        private int height;

        public Node(Key key) {
            this.key = key;
        }
    }

    Node find(Key key) {
        return find(key, root);
    }

    private Node find(Key key, Node node) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return find(key, node.left);
        else if (cmp > 0)
            return find(key, node.right);
        else
            return node;
    }

    public void insert(Key key) {
        root = insert(key, root);
    }

    private Node insert(Key key, Node node) {
        if (node == null)
            return new Node(key);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(key, node.left);
        } else if (cmp > 0) {
            node.right = insert(key, node.right);
        } else {
            throw new RuntimeException("duplicate key");
        }
        return reBalance(node);
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return node;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = node.left == null ? node.right : node.left;
            } else {
                Node leftChild = mostLeftChild(node.right);
                node.key = leftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null)
            node = reBalance(node);
        return node;
    }

    private Node reBalance(Node node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            if (height(node.right.right) > height(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        } else if (balance < -1) {
            if (height(node.left.left) > height(node.left.right)) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }
        return node;
    }

    private Node rotateRight(Node node) {
        Node nodeLeft = node.left;
        Node leftRight = nodeLeft.right;
        nodeLeft.right = node;
        node.left = leftRight;
        updateHeight(node);
        updateHeight(nodeLeft);
        return nodeLeft;
    }

    private Node rotateLeft(Node node) {
        Node rightNode = node.right;
        Node rightLeft = rightNode.left;
        rightNode.left = node;
        node.right = rightLeft;
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private void printTree(Node currPtr, String indent, boolean last) {
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(currPtr.key);
            printTree(currPtr.left, indent, false);
            printTree(currPtr.right, indent, true);
        }

    }

    private Node mostLeftChild(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    public int getBalance(Node node) {
        return (node == null) ? 0 : height(node.right) - height(node.left);
    }



}
