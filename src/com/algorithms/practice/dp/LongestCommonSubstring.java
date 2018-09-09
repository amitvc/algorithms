package com.algorithms.practice.dp;

public class LongestCommonSubstring {
	
	
	
	//s1 = "abcba"
	//s2 = "bcbad"
	// ans = bcba - 4
	public static int longestCommonSubstring(String s1, String s2, int i1, int i2, int l1, int l2) {
		if(i1 >= l1 || i2 >= l2) {
			return 0;
		}
		if(s1.charAt(i1) == s2.charAt(i2)) {
			return 1+longestCommonSubstring(s1, s2, i1+1, i2+1, l1, l2);
		} else {
			return Math.max(longestCommonSubstring(s1, s2, i1+1, i2, l1, l2), longestCommonSubstring(s1, s2, i1, i2+1, l1, l2));
		}
	}

	public static void main(String[] args) {
		String s1 = "zxabcdezy";
		String s2 = "yzabcdezx";
		System.out.println("Longest Common substring = "+longestCommonSubstring(s1, s2, 0, 0, s1.length(), s2.length()));
	}

}
