package com.algorithms.stacks;

import java.util.Stack;

public class MaxValidParanthesis {
	
	public static int  maxValidParenthesis(String s) {
		int lastMax = 0;
		Stack<Character> stack = new Stack<>();
		
		int currentMax = 0;
		for(int i=0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			} else {
				if(!stack.isEmpty()) {
					stack.pop();
					currentMax += 2;
				} else {
					currentMax = 0;
				}
				lastMax = Math.max(lastMax, currentMax);
			}
		}
		return lastMax;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxValidParenthesis("((())"));

	}

}
