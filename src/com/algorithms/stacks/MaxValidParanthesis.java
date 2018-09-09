package com.algorithms.stacks;

import java.util.Stack;

public class MaxValidParanthesis {

	public static int findMaxLen(String str) {
		int n = str.length();

		// Create a stack and push -1 as initial index to it.
		Stack<Integer> stk = new Stack<>();
		stk.push(-1);

		// Initialize result
		int result = 0;

		// Traverse all characters of given string
		for (int i = 0; i < n; i++) {
			// If opening bracket, push index of it
			if (str.charAt(i) == '(')
				stk.push(i);

			else // If closing bracket, i.e.,str[i] = ')'
			{
				// Pop the previous opening bracket's index
				int t = stk.pop();

				// Check if this length formed with base of
				// current valid substring is more than max
				// so far
				if (!stk.empty())
					result = Math.max(result, i - stk.peek());

				// If stack is empty. push current index as
				// base for next valid substring (if any)
				else
					stk.push(i);
			}
		}

		return result;
	}
	
	public static int longestValidParenthesis(String str){
		int maxLen = 0;
		int start = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i<str.length(); i++){
			if(str.charAt(i) == '('){
				stack.push(i);
			}
			else{
				//no matching left - update start to next position
				if(stack.isEmpty()){
					start = i+1;
				}
				else{
					int startIndex = stack.pop();
					//update maxima
					maxLen = Math.max(maxLen, i-startIndex+1);
					//after poping start if there is no start left on the stack indicating 
					//that this pair of parenthesis may be a part of longer substring
					//for example, consider the case for ()()()
					if(stack.isEmpty()){
						maxLen = Math.max(maxLen, i-start+1);
					}
				}
			}
		}
		
		return maxLen;
	}

	public static int maxValidParenthesis(String s) {
		int n = s.length();
		int longest = 0;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) { // scan string from beginning to end
			if (s.charAt(i) == '(') {
				// current character is '(',push its index to the stack
				st.push(i);
			} else { // current character is ')'
				if (!st.empty() && s.charAt(st.peek()) == '(') {
					// top of stack is '('. Matching pair is found.
					st.pop();
				} else {
					st.push(i);
				}
			}
		}

		// stack now contains indices of characters that were not initially
		// matched.
		if (st.empty()) {
			return n; // entire string was matched, return string length
		} else {
			// substring between adjacent stack indices are valid parentheses
			// find longest index gap
			int a = n;
			while (!st.empty()) {
				int b = st.pop();
				longest = Math.max(longest, a - b - 1);
				a = b;
			}
			longest = Math.max(longest, a);
		}
		return longest; // return longest index gap
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxValidParenthesis("(()))"));
		System.out.println(maxValidParenthesis("((()()"));
		System.out.println(maxValidParenthesis("()(()))))"));
		System.out.println(maxValidParenthesis("()(()))))"));
		System.out.println(longestValidParenthesis(
				")()))(())((())))))())()(((((())())((()())(())((((())))())((()()))(()(((()()(()((()()))(())()))((("));

	}

}
