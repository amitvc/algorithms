package com.algorithms.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @amitvc
 */
public class PrintVerticalOrder {

    public static class Node {
        public Node left, right;
        public int value;

        public Node(int a) {
            this.value = a;
        }
    }

    public static Node createTree() {
        Node root = new Node(1);
        Node r2 = new Node(2);
        Node r3 = new Node(3);
        Node r4 = new Node(4);
        Node r5 = new Node(5);
        Node r6 = new Node(6);
        Node r7 = new Node(7);
        Node r8 = new Node(8);
        root.left = r2;
        root.right = r3;
        r3.left = r5;
        r3.right = r6;
        r5.left = r7;
        r5.right = r8;
        return root;
    }


    public static void printVertical(Node r) {
        Map<Integer, LinkedList<Node>> lMap = new HashMap<>();
        int center = 0;
        printVertical(r,0, lMap);
        System.out.println(lMap);
    }

    private static void printVertical(Node r, int level, Map<Integer,LinkedList<Node>> nodesCache) {
        if(r == null) return;
        LinkedList<Node> q = null;
        if(nodesCache.containsKey(level)) {
            q = nodesCache.get(level);

        } else {
            q = new LinkedList<>();
            nodesCache.put(level, q);
        }
        q.add(r);
        printVertical(r.left, level-1, nodesCache);
        printVertical(r.right, level+1, nodesCache);
    }


    public static void main(String args[]) {
        System.out.println("Printing Vertical order of the tree");
        printVertical(createTree());

    }

}
