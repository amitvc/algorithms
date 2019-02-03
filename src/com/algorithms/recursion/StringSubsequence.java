package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StringSubsequence {
	
	public static void printSubSequence(String s, List<String> cache) {
		if(s.isEmpty()) {
			cache.add("");
			return;
		}
		
		char cc = s.charAt(0);
		printSubSequence(s.substring(1), cache);
		int size = cache.size();
		
		for(int i=0; i < size; i++) {
			cache.add(cc+""+cache.get(i));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> cache = new ArrayList<>();
		printSubSequence("abc", cache );
		System.out.println(cache);
	}

}
