package com.algorithms.trees;

public class TreeIsBST {


    public static boolean isValidBST(Node root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBST(Node r, int min, int max) {
        if (r == null) return true;

        if (r.data <= min || r.data >= max) return false;

        return isValidBST(r.left, min, r.data) && isValidBST(r.right, r.data, max);

    }


    public static void main(String[] args) {

        Node r = BinaryTreeProvider.getTree("1,#,1");
        System.out.println("Is Balanced  " + isValidBST(r));
    }
}
