package com.vinay.practice;

public class RedBlackTree<Key extends Comparable<Key>, Value> {


    private Node root;
    private static boolean RED = true;
    private static boolean black = false;

    private class Node{
        private Key key;
        private Value value;
        private Node left, right;
        boolean color;
        private int count;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }


    public boolean isRED(Node x){
        if(x == null){
            return false;
        }
        return x.color == RED;
    }


    public Value getKey(Key key){
        Node x = null;
        while(x != null){
            int cmp = key.compareTo(x.key);
            if(cmp < 0){
                x = x.left;
            }else if(cmp > 0){
                x =x .right;
            }else{
                return x.value;
            }
        }
        return null;
    }

}
