package com.algorithms.practice2022.trees;

public class BinaryTree {

    public static class BinaryTreeNode {
        private final int value;
        private BinaryTreeNode left, right;
        public BinaryTreeNode(int v) {
            value  = v;
        }

        public int getValue() {
            return value;
        }
        public void setLeft(BinaryTreeNode n) {
            left = n;
        }

        public void setRight(BinaryTreeNode n) {
            right = n;
        }

        public BinaryTreeNode getLeft() {
            return left;
        }

        public BinaryTreeNode getRight() {
            return right;
        }
    }

    public static void main(String[] args) {
        String serializedBinaryTree = "5,3,2,#,#,#,6,#,7,#,#";
        BinaryTreeNode root = BinaryTreeSerializer.deserializeTree(serializedBinaryTree);
        System.out.println(root);
        System.out.println(BinaryTreeSerializer.serializeBinaryTree(root));
    }
}
