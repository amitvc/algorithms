package com.algorithms.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PhoneNumberDigits {

	public static Map<Character, String> lookup = new HashMap<>();

	static {
		lookup.put('2', "abc");
		lookup.put('3', "def");
		lookup.put('4', "ghi");
		lookup.put('5', "jkl");
		lookup.put('6', "mno");
		lookup.put('7', "pqrs");
		lookup.put('8', "tuv");
		lookup.put('9', "wxyz");
	}

	public static List<String> enumerate(String digits) {
		List<String> results = new ArrayList<>();

		// 234
		enumerate("", digits, results);
		return results;
	}

	private static void enumerate(String prefix, String digits, List<String> results) {
		if (!digits.isEmpty()) {
			char currentChar = digits.charAt(0);
			String charCode = lookup.get(currentChar);
			for (int i = 0; i < charCode.length(); i++) {
				enumerate(prefix + charCode.charAt(i), digits.substring(1), results);
			}
		} else {
			results.add(prefix);
			return;
		}
	}
	
	
	private static List<String> treeWithBackTracking(String digits) {
		List<String> results = new ArrayList<>();
		dfsWithBacktracking(0,1, "",digits, results);
		return results;
	}
 	

	private static void dfsWithBacktracking(int currentIndex, int nextIndex, String currentString, String digits, List<String> results) {
		if(nextIndex > digits.length()) {
			results.add(currentString);
		} else {
			String codes = lookup.get(digits.charAt(currentIndex));
			for(int i=0; i < codes.length(); i++) {
				dfsWithBacktracking(nextIndex, nextIndex+1, currentString +  codes.charAt(i), digits, results);
			}
		}
	}

	public static List<String> bottumUp(String digits) {
		List<String> results = new ArrayList<>();
		int length = digits.length() - 1;
		Queue<String> temp = new LinkedList<>();
		String lastCharCode = lookup.get(digits.charAt(length));
		for(int i=0; i < lastCharCode.length(); i++) {
			temp.offer(""+lastCharCode.charAt(i));
		}
		length--;
		while (length >= 0) {
			char lastChar = digits.charAt(length);
			length--;
			String codes = lookup.get(lastChar);
			int count = temp.size();
			for (int i = 0; i < codes.length(); i++) {
				char c = codes.charAt(i);
				while (count > 0) {
					count--;
					String current = temp.poll();
					temp.offer(c + current);
				}
			}
			System.out.println("");
		}
		System.out.println(temp.toString());
		return results;
	}

	public static void main(String[] args) {
		List<String> results = PhoneNumberDigits.enumerate("234");
		System.out.println(results.toString());
		System.out.println(PhoneNumberDigits.treeWithBackTracking("234").toString());
	}
}
