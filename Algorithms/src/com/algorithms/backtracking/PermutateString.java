package com.algorithms.backtracking;

public class PermutateString {
	
	
	public static void permute(String prefix, String s) {
		int n = s.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
            	permute(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
        }
	}

	
	public static void main(String[] args) {
		PermutateString.permute("", "abcdefghij");
	}

}
