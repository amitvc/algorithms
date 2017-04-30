package com.algorithms.arrays;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxSubStringNonRepeating {

	public static int longestSubString(String s) {
		int maxSoFar = 0;
		int startIndex = 0;
		Set<Character> lookup = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (!lookup.contains(c)) {
				lookup.add(c);
				maxSoFar = Math.max(maxSoFar, i - startIndex + 1);
			} else {
				for (int j = startIndex; j < i; j++) {
					lookup.remove(s.charAt(j));

					if (s.charAt(j) == c) {
						startIndex = j + 1;
						break;
					}
				}
				lookup.add(c);
			}
		}
		return maxSoFar;
	}

	public static int longestNonRepeatingSubstringB(String s) {
		Set<Character> found = new HashSet<Character>();
		int longest = 0, current = 0;
		for (int index = 0; index < s.length(); ++index) {
			char ch = s.charAt(index);
			if (!found.contains(ch)) {
				current++;
			} else {
				longest = Math.max(longest, current);
				current = 1;
				found.clear();
			}
			found.add(ch);
		}
		return Math.max(longest, current);
	}

	public static void main(String[] args) {
		Map<String, String> s;
		System.out.println(MaxSubStringNonRepeating.longestSubString("abcabdef"));
		System.out.println(MaxSubStringNonRepeating.longestSubString("aabbccdd"));
		System.out.println(longestNonRepeatingSubstringB("abcabdef"));

	}

}
