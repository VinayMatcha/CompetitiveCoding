package com.vinay.trees;

public class BinaryTree {

    public Node root;

    private class Node {
        private int value;
        private Node left, right;

        public Node(int val) {
            this.value = val;
        }
    }

    private class HeightCalculator {
        private int height;
        private boolean isBalanced;
        public HeightCalculator() {
            this.height = 0;
        }
    }

    boolean isFullBinaryTree(Node node) {
        if (node == null)
            return true;
        if (node.left == null || node.right == null)
            return true;
        if (node.left != null && node.right == null)
            return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
        return false;
    }

    boolean isCompleteTree(Node node) {
        if (node == null)
            return true;
        int totalNodes = nodesCount(node);
        return isCompleteTree(node, 0, totalNodes);
    }

    boolean isBalancedTree(Node node) {
        if (node == null)
            return true;
        HeightCalculator heightCalculator = new HeightCalculator();
        isBalancedTree(node, heightCalculator);
        return heightCalculator.isBalanced;
    }

    private void isBalancedTree(Node node, HeightCalculator heightCalculator) {
        if (node == null) {
            heightCalculator.isBalanced = true;
            return;
        }
        HeightCalculator leftHeightCalculator = new HeightCalculator();
        HeightCalculator rightHeightCaluculator = new HeightCalculator();
        isBalancedTree(node.left, leftHeightCalculator);
        isBalancedTree(node.right, rightHeightCaluculator);
        heightCalculator.height = Math.max(leftHeightCalculator.height, rightHeightCaluculator.height) + 1;
        if (Math.abs(leftHeightCalculator.height - rightHeightCaluculator.height) > 1 || !leftHeightCalculator.isBalanced || !rightHeightCaluculator.isBalanced) {
            heightCalculator.isBalanced = false;
            return;
        }
        heightCalculator.isBalanced = true;
    }

    private boolean isCompleteTree(Node node, int index, int totalNodes) {
        if (index >= totalNodes)
            return false;

        return isCompleteTree(node.left, 2*index+1, totalNodes) && isCompleteTree(node.right, 2*index+2, totalNodes);
    }


    boolean isPerfectTree (Node node) {
        int height = getHeight(node);
        if (node == null)
            return true;
        return isPerfectTree(node, height, 0);
    }

    private boolean isPerfectTree(Node node, int height, int level) {
        if (node.right == null && node.left == null)
            return (level+1 == height);
        if (node.right == null || node.left == null)
            return false;
        return isPerfectTree(node, height, level+1) && isPerfectTree(node, height, level+1);
    }

    public int getHeight (Node node) {
        if (node == null)
            return 0;
        int rightHeight = getHeight(node.right);
        int leftHeight = getHeight(node.left);
        return Math.max(rightHeight, leftHeight) + 1;
    }

    private int nodesCount(Node node) {
        if (node == null)
            return 0;
        return 1 + nodesCount(node.left) + nodesCount(node.right);
    }
}
