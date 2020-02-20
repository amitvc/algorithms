package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class PermuteString {
	
	public static void permute(String original) {
		permute("", original);
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


	/**
	 *
	 * LSE
	 *
	 * SE, ES
	 *
	 * LSE
	 * LES
	 * SLE
	 * SEL
	 * ESL
	 * ELS
	 *
	 * L + permute("SE")
	 * S + permute("LE")
	 * E + permute("LS")
	 *
	 *
	 */
	public static List<String> permuteString(String value) {

		if(value != null && value.length() == 1) {
			return Arrays.asList(value);
		}

		List<String> previous = permuteString(value.substring(1));
		char c0 = value.charAt(0);

		List<String> result = new ArrayList<>();
		for(String s : previous) {
			for (int i=0; i < s.length()+1;i++) {
				result.add(s.substring(0,i) + c0 + s.substring(i));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		permute("abc");
		List<String> r = permuteString("LSE");
		System.out.println("Result "+ r);

		Function<String, Integer> p = ss -> ss.length();
	}
}
