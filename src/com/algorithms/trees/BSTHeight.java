package com.algorithms.trees;

import java.util.ArrayList;

public class BSTHeight {
    
    public static class Node {
        public int val;
        public Node left, right;
        public Node(int val) {
            this.val = val;
        }
    }
    
    public int height(Node n) {
        if(n == null) return 0;
        
        int left = height(n.left);
        int right = height(n.right);
        return Math.max(left, right) +1;
    }
    
    
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> result = new ArrayList<>();
        generate(result, "", n, 0, 0);
        return result;
    }

    private void generate(ArrayList<String> result, String buffer, int n, int left, int right) {
        if (buffer.length() == n * 2) {
            result.add(buffer);
            return;
        }
        if (left < n) {
            generate(result, buffer + "(", n, left + 1, right);
        }
        if (left > right) {
            generate(result, buffer + ")", n, left, right + 1);
        }
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(5);
        Node n3 = new Node(20);
        Node n4 = new Node(25);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n1.left = n2;
        n1.right = n3;
        n3.right = n4;
        n2.right = n6;
        n6.right = n7;
        n7.right = n8;
        BSTHeight bst = new BSTHeight();
        System.out.println("Height --> " + bst.height(n1));
        /**
         *         10
         *     5         20
         *        6          25 
         *           7
         *             8
         * 
         * 
         */
        System.out.println(bst.generateParenthesis(3));
    }

}
