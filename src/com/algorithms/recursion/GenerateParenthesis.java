package com.algorithms.recursion;

public class GenerateParenthesis {

	public static void generate(int n) {
		generate(n, 0, 0, "");
	}


	public static void generate(int n, int left, int right, String current) {

		if (current.length() == n*2) {
			System.out.println(current);
			return;
		}

		if (left < n) {
			generate(n, left+1, right, current+"(");
		}

		if (right < left) {
			generate(n, left, right+1, current+")");
		}

	}


	/**
	 * ((()))
	 * (())()
	 * ()(())
	 * ()()()
	 * (()())
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate(4);
	}

}
