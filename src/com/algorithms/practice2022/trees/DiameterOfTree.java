package com.algorithms.practice2022.trees;

import java.util.concurrent.atomic.AtomicInteger;

import com.algorithms.practice2022.trees.BinaryTree.BinaryTreeNode;

public class DiameterOfTree {

    public static int diameter(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        AtomicInteger diameter = new AtomicInteger();
        diameter(root, diameter);
        return diameter.get();
    }

    private static void diameter(BinaryTreeNode root, AtomicInteger diameter) {

    }

    public static void main(String[] args) {
        String input = "1,3,7,8,9,#,#,#,#,4,#,5,#,6,#,#,2,#,#";
        BinaryTreeNode root = BinaryTreeSerializer.deserializeTree(input);
        System.out.println(root);
    }
}
