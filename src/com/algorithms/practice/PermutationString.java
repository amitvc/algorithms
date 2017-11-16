package com.algorithms.practice;

import java.util.ArrayList;
import java.util.List;

public class PermutationString {
	
	
	public static List<String> permute(String s) {
		List<String> permutes = new ArrayList<>();
		permute("", s, permutes);
		return permutes;
	}
	
	private static void permute(String prefix, String postFix, List<String> permutes) {
		if(postFix.isEmpty()) {
			permutes.add(prefix);
			return;
		}
		
		for(int i=0; i < postFix.length(); i++) {
			permute(prefix+postFix.charAt(i), postFix.substring(0,i) + postFix.substring(i+1), permutes);
		}
	}
	
	public static void permuteBackTracking(String s) {
		permuteSoFar(s, "");
	}
	
	public static void permuteSoFar(String originalString, String soFar) {
		if(originalString.isEmpty()) {
			System.out.println(soFar);
		}
		
		for(int i=0;i < originalString.length(); i++) {
			char c = originalString.charAt(i);
			soFar +=c;
			permuteSoFar(originalString.substring(0, i) + originalString.substring(i+1), soFar);
			soFar = soFar.substring(0, soFar.length()-1);			
		}
	}

	public static void main(String[] args) {
		List<String> result = PermutationString.permute("abc");
		System.out.println(result.toString());
		permuteBackTracking("abc");
	}

}
