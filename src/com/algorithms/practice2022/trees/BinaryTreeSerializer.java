package com.algorithms.practice2022.trees;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

import com.algorithms.practice2022.trees.BinaryTree.BinaryTreeNode;

public class BinaryTreeSerializer {

    public static BinaryTreeNode deserializeTree(String data) {
        String tokens[] = data.split(",");
        Queue<String> queue = new ArrayDeque<String>();
        Arrays.stream(tokens).forEach(e -> queue.offer(e));

        return deserializeTree(queue);
    }

    private static BinaryTreeNode deserializeTree(Queue<String> queue) {
        String val = queue.poll();
        if (val.equalsIgnoreCase("#")) {
            return null;
        }

        BinaryTreeNode node = new BinaryTreeNode(Integer.parseInt(val));
        BinaryTreeNode left = deserializeTree(queue);
        BinaryTreeNode right = deserializeTree(queue);
        node.setLeft(left);
        node.setRight(right);
        return node;
    }

    public static String serializeBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return "#";
        }
        if (isLeaf(root)) {
            return root.getValue() + ",#,#";
        }

        String left = serializeBinaryTree(root.getLeft());
        String right = serializeBinaryTree(root.getRight());
        return root.getValue() + "," + left + "," + right;
    }

    private static boolean isLeaf(BinaryTreeNode node) {
       return (node != null && (node.getLeft() == null && node.getRight() == null)) ? true : false;
    }
}
