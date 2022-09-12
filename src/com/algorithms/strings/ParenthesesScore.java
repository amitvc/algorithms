package com.algorithms.strings;

import java.util.Stack;

public class ParenthesesScore {

    public static int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(cur);
                cur = 0;
            } else {
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }


    public static void main(String[] args) {
        // ((())) = 4
        // ((())
        System.out.println("Score " + scoreOfParentheses("(()(())())()"));
        System.out.println("Score " + scoreOfParentheses("((()))"));
    }

}
