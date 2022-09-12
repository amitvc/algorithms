package com.algorithms.trees;

import java.util.Stack;

public class InOrderTraversal {

    public static void inOrderIterative(Node root) {
        if (root == null) {
            System.out.println("Nothing todo");
        }
        
        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Node current = root;
        while(true) {

            while(current != null) {
                stack.push(current);
                current = current.left;
            }

            if (stack.isEmpty()) break;
            current = stack.pop();
            sb.append(current.data +",");
            current = current.right;
        }

        System.out.println("In Order " + sb);
    }




    
    public static void main(String[] args) {

        Node r = BinaryTreeProvider.getTree("100,50,25,#,#,75,65,#,#,85,#,#,120,110,#,#,130,#,#");
        inOrderIterative(r);
    }
}
