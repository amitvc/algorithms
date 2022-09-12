package com.algorithms.practice2022.trees;

import java.util.concurrent.atomic.AtomicInteger;

public class ConstructTreeFromInOrderPreOrder {


    private static class Node {
        private String value;
        public Node left, right;

        public Node(String v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        String[] preOrder = {"a", "b", "d", "e", "c", "f", "g"};
        String[] inOrder = {"d", "b", "e", "a", "f", "c", "g"};

        Node root = constructTree(preOrder, inOrder);
        System.out.println(root);
    }

    private static Node constructTree(String[] preOrder, String[] inOrder) {
        if (preOrder.length != preOrder.length) {
            throw new IllegalArgumentException("InOrder and PostOrder array length for given tree cannot be unequal");
        }

        return construct(preOrder, inOrder, new AtomicInteger(0), 0, inOrder.length - 1);
    }

    public static int indexOfValue(String[] values, String val) {
        int i=0;
        for (String s : values) {
            if (val.equals(s)) {
                return i;
            }
            i++;
        }

        return i;
    }

    private static Node construct(String[] preOrder, String[] inOrder, AtomicInteger preOrderIdx, int si, int ei) {

        if (si > ei) {
            return null;
        }

        if (preOrderIdx.get() >= inOrder.length) {
            return null;
        }

        int idx = preOrderIdx.getAndIncrement();
        Node root = new Node(preOrder[idx]);

        if (si == ei) {
            return root;
        }

        int idxOfRoot = indexOfValue(inOrder, preOrder[idx]);

        Node left = construct(preOrder, inOrder, preOrderIdx, si, idxOfRoot-1);
        Node right = construct(preOrder, inOrder, preOrderIdx, idxOfRoot+1, ei);
        root.left = left;
        root.right = right;
        return root;

    }
}
