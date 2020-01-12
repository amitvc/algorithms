package com.algorithms.backtracking;

import java.util.HashSet;
import java.util.Set;

public class WordBreaking {
	
	public static Set<String> dictionary = new HashSet<>();
	
	static {
		dictionary.add("dogs");
		dictionary.add("dog");
		dictionary.add("be");
		dictionary.add("bed");
		dictionary.add("and");
		dictionary.add("beds");
		dictionary.add("sand");
		dictionary.add("bath");
		dictionary.add("beyond");

	}

	
	public static void wordBreak(String s) {
		helper(s, "");
	}
	
	//bedsand
	// bed sand
	// beds and
	public static void helper(String current, String soFar) {
		String t = "";
		for(int i=0; i < current.length(); i++) {
			t += current.charAt(i);
			if(dictionary.contains(t)) {
				if(i == current.length()-1) {
					System.out.println(soFar + " "+ t);
				} else {
					helper(current.substring(i+1), soFar + " " + t);
				}
			}
		}
	} //bedsand
	// 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wordBreak("bedsbathandbeyond");
	}

}
