package com.algorithms.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class InOrderTraversal {
    
    public static class Node {
        public int val;
        public Node left, right;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
    
    public void inOrderIterative(Node root) {
        if (root == null) {
            System.out.println("Nothing todo");
        }
        
        Deque<Node> stack = new ArrayDeque<>();
        Node child = null;
        stack.offer(root);
        
        while(!stack.isEmpty()) {
            
        }
    }
    
    
    public static void main(String[] args) {
    }
}
