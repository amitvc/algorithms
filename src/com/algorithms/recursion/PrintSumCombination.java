package com.algorithms.recursion;

import java.util.Stack;

public class PrintSumCombination {
	
	public static void calculate(int i, int n, Stack<Integer> current) {
		if(n == 0) {
			System.out.println(current.toString());
			return;
		}
		
		for(int j=i; j <= n; j++) {
			current.push(j);
			calculate(j, n-j, current);
			current.pop();
		}
	}

	public static void main(String[] args) {
		calculate(1, 4, new Stack<>());
		// TODO Auto-generated method stub
		/**
		 * 
		 * 
		 *   n=3 
		 *   
		 *   [1], print(2) -- 
		 *   [2], print(1) --
		 *   [3], print(0)
		 * 
		 * 
		 */

	}

}
