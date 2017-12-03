package com.algorithms.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordBreak {

	static Set<String> dictionary = new HashSet<>();

	static {
		dictionary.add("mango");
		dictionary.add("mobile");
		dictionary.add("samsung");
		dictionary.add("man");
		dictionary.add("i");
		dictionary.add("love");
		dictionary.add("ice");
		dictionary.add("cream");
		dictionary.add("icecream");
		dictionary.add("go");
		dictionary.add("and");
	}

	public static void wordBreak(String s) {
		wordBreakUtil(s, s.length(), "");
	}

	public static void wordBreakUtil(String str, int n, String result) {
		// Process all prefixes one by one
		for (int i = 1; i <= n; i++) {
			// extract substring from 0 to i in prefix
			String prefix = str.substring(0, i);

			// if dictionary conatins this prefix, then
			// we check for remaining string. Otherwise
			// we ignore this prefix (there is no else for
			// this if) and try next
			if (dictionary.contains(prefix)) {
				// if no more elements are there, print it
				if (i == n) {
					// add this element to previous prefix
					result += prefix;
					System.out.println(result);
					return;
				}
				wordBreakUtil(str.substring(i, n), n-i , result + prefix + " ");
			}
		} // end for
	}// end function

	public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet(wordDict);
		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[s.length()];
		queue.add(0);
		while (!queue.isEmpty()) {
			int start = queue.remove();
			if (visited[start] == 0) {
				for (int end = start + 1; end <= s.length(); end++) {
					if (wordDictSet.contains(s.substring(start, end))) {
						queue.add(end);
						if (end == s.length()) {
							return true;
						}
					}
				}
				visited[start] = 1;
			}
		}
		return false;
	}

	// iloveicecream

	// output
	// i love ice cream
	// i love icecream

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wordBreak("catsanddog", Arrays.asList("cats", "cat", "sand", "and", "dog"));
		wordBreak("iloveicecream");

	}

}
