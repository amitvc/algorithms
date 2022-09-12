package com.algorithms.practice2022.trees;

import java.util.concurrent.atomic.AtomicInteger;


public class ConstructTreeFromInOrderPostOrder {


    private static class Node {
        private String value;
        public Node left, right;

        public Node(String v) {
            value = v;
        }
    }
    public static void main(String[] args) {
        String[] inOrder = {"d", "b", "e", "a", "f", "c", "g"};
        String [] postOrder = {"d", "e", "b", "f", "g", "c", "a"};
        Node root = construct(inOrder, postOrder);
        System.out.println(root);
    }

    private static Node construct(String[] inOrder, String[] postOrder) {

        if (inOrder.length != postOrder.length) {
            throw new IllegalArgumentException("InOrder and PostOrder array length for given tree cannot be unequal");
        }

        return construct(inOrder, postOrder, new AtomicInteger(inOrder.length-1), 0, inOrder.length-1);
    }

    private static Node construct(String[] inOrder, String[] postOrder, AtomicInteger poIdx, int si, int ei) {

        if (si > ei) {
            return null;
        }

        if (poIdx.get() < 0) {
            return null;
        }

        int idx = poIdx.getAndDecrement();
        Node root = new Node(postOrder[idx]);

        if (si == ei) {
            return root;
        }

        int idxOfRoot = ConstructTreeFromInOrderPreOrder.indexOfValue(inOrder, postOrder[idx]);

        Node right = construct(inOrder, postOrder, poIdx, idxOfRoot + 1, ei);
        Node left = construct(inOrder, postOrder, poIdx, si, idxOfRoot - 1);

        root.left = left;
        root.right = right;
        return root;

    }
}
