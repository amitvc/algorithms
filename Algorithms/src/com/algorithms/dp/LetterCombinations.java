package com.algorithms.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinations {

	static final HashMap<Character, String> map = new HashMap<Character, String>() {
		{
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}
	};
	
	
	
	// 234
	
	public static void letters(String number, int startIndex, String current, List<String> values) {

		if(startIndex >= number.length()) {
			values.add(current);
			System.out.println(current);
		} else {
			String digitCode = map.get(number.charAt(startIndex));
			for(int i=0; i < digitCode.length(); i++) {
				letters(number, startIndex+1, current + digitCode.charAt(i), values);
			}
		}
	}
	
	

	/**
	 * This problem is solved using creating a tree on the fly and doing BFS. At
	 * each level in the tree we are adding character codes corresponding to the
	 * number in the sequence. This can be solved with backtracking using
	 * recursive routine.
	 * 
	 * @param digits
	 * @return
	 */
	public static List<String> letterCombinationItr(String digits) {
		if (digits.length() == 0) {
			return new ArrayList<>();
		}

		String rootCode = map.get(digits.charAt(0));
		Queue<String> codes = new LinkedList<>();

		for (int i = 0; i < rootCode.length(); i++) {
			codes.add("" + rootCode.charAt(i));
		}

		for (int i = 1; i < digits.length(); i++) {
			Queue<String> tempCodes = new LinkedList<>();
			String numCodes = map.get(digits.charAt(i));
			while (!codes.isEmpty()) {
				String t = codes.poll();
				for (int j = 0; j < numCodes.length(); j++) {
					tempCodes.add(t + numCodes.charAt(j));
				}
			}
			codes = tempCodes;
		}

		List<String> characterEnumerations = new ArrayList<>(codes);
		return characterEnumerations;
	}

	/**
	 * Recursive version
	 */
	public static List<String> letterCombos(String digits, int startAt, String current, List<String> combos) {
	//	System.out.println("Calling letterCombos");
        if(startAt < digits.length()) {
            String letters = map.get(digits.charAt(startAt));
            for(int letterIndex = 0; letters != null && letterIndex < letters.length(); ++letterIndex) {
                letterCombos(digits, startAt + 1, current + letters.charAt(letterIndex), combos);
            }
            return combos;
        }
        combos.add(current);
        return combos;
    }
	
	
	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();

		int n = digits.length();
		if (n < 1)
			return result;

		result.add("");

		for (int i = 0; i < n; i++) {
			char c = digits.charAt(i);
			if (!map.containsKey(c))
				return new ArrayList<>();
			String s = map.get(c);
			List<String> temp = new ArrayList<>();
			for (String element : result) {
				for (char extra : s.toCharArray()) {
					temp.add(element + extra);
				}
			}
			result = temp;
		}
		return result;
	}

	public static String rev(String s) {
		char chars[] = s.toCharArray();
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			char t = chars[i];
			chars[i] = chars[j];
			chars[j] = t;
		}
		return new String(chars);
	}

	public static void backtracking(String digits, int startIndex, List<String> values, 
			String currentValue) {
		System.out.println(" "+currentValue);
		if(startIndex == digits.length()-1) {
			// This means I have reached the last part
			String chars = map.get(digits.charAt(startIndex));
			for(int i=0; i < chars.length(); i++) {
				String finalVal = currentValue + chars.charAt(i);
				values.add(finalVal);
			}
			return;

		} else {
			String chars = map.get(digits.charAt(startIndex));
			for(int i=0; i < chars.length(); i++) {
				backtracking(digits, startIndex+1, values, currentValue + chars.charAt(i));
			}
		}

	}

	public static void main(String arg[]) {
		//System.out.println(rev("Amit"));
		// System.out.println(LetterCombinations.letterCombinationItr("234"));
		//List<String> l = new ArrayList<>();
		//System.out.println(LetterCombinations.letterCombos("23456789",0,"", l));
		//System.out.println(letterCombos("23456789", 0, "", new ArrayList<String>()));
		List<String> values = new ArrayList<>();
		letters("234", 0, "", values);
		//LetterCombinations.backtracking("234", 0, values, "");
		//System.out.println(values);
	}
}
