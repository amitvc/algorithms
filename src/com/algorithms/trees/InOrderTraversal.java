package com.algorithms.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class InOrderTraversal {

    public static void inOrderIterative(Node root) {
        if (root == null) {
            System.out.println("Nothing todo");
        }
        
        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Node c = root;
        while(true) {

            while(c != null) {
                stack.push(c);
                c = c.left;
            }

            if (stack.isEmpty()) break;
            c = stack.pop();
            sb.append(c.data +",");
            c = c.right;
        }

        System.out.println("In Order " + sb.toString());
    }
    
    
    public static void main(String[] args) {

        Node r = BinaryTreeProvider.getTree("1,2,4,#,9,11,12,#,#,#,10,#,#,3,6,#,#,7,#,#");
        inOrderIterative(r);
    }
}
