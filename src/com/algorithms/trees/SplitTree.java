package com.algorithms.trees;

public class SplitTree {

    public static Node[] splitBST(Node root, int V) {
        Node[] res = new Node[]{null, null};
        if (root == null) {
            return res;
        }

        if (root.data == V) {
            res[0] = root;
            Node t = root.right;
            root.right = null;
            res[1] = t;
            return res;
        }

        if (root.data < V) {
            res = splitBST(root.right, V);
            root.right = res[0];
            res[0] = root;
        } else {
            res = splitBST(root.left, V);
            root.left = res[1];
            res[1] = root;
        }
        return res;
    }
    public static void main(String[] args) {
        Node root = BinaryTreeProvider.getTree("10,5,3,#,#,7,6,#,#,8,#,9,#,#,12,11,#,#,15,13,#,#,#");
        System.out.println(root.data);
        Node rr[] = splitBST(root, 7);
        System.out.println(rr[0]);
    }
}
