package com.algorithms.trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeProvider {


    ///4,

    public static String serializer(Node n) {

        if (n == null) {
            return "#";
        }

        String leftTree = serializer(n.left);
        String rightTree = serializer(n.right);
        return String.join(",", ""+n.data, leftTree, rightTree);
    }


    public static Node getTree(String values) {
        String[] treeNodes = values.split(",");
        Queue<String> queue = new ArrayDeque<>();
        for (String s : treeNodes) {
            queue.offer(s);
        }

        return getTree(queue);
    }

    private static Node getTree(Queue<String> q) {
        if(q.isEmpty()) {
            return null;
        }

        String nodeValue = q.poll();
        if(nodeValue.equalsIgnoreCase("#")) {
            return null;
        }

        Node n = new Node(Integer.parseInt(nodeValue));

        Node l = getTree(q);
        Node r = getTree(q);

        n.left = l;
        n.right = r;
        return n;
    }

    public static void main(String[] args) {
        Node r = BinaryTreeProvider.getTree("10,5,3,#,#,7,6,#,#,8,#,9,#,#,12,11,#,#,15,13,#,#,#");
        System.out.println(r.data);
    }

}
