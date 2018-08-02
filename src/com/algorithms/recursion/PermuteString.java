package com.algorithms.recursion;

public class PermuteString {
	
	public static void permute(String orginal) {
		permute("", orginal);
	}
	
	public static void permute(String current, String remaining) {
		if(remaining.isEmpty()) {
			System.out.println(current);
			return;
		}
		
		//Go through each character in string and perform this  
		// current char + permutation(remaining string)  
		// remaining string -- the original string minus the currently selected character
		for(int i=0; i < remaining.length(); i++) {
			char c = remaining.charAt(i);
			permute(c+current, remaining.substring(0,i) + remaining.substring(i+1));
		}
	}

	public static void main(String[] args) {
		permute("abc");
	}

}
