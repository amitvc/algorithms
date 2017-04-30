package com.algorithms.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermutateString {
	public static void perm2(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        perm2(a, n);
    }

    private static void perm2(char[] a, int n) {
        if (n == 1) {
            System.out.println(a);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            perm2(a, n-1);
            swap(a, i, n-1);
        }
    }  

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
	
	public static void permute(String prefix, String s) {
        if (s.equals("")) System.out.println(prefix);
        else {
            for (int i = 0; i < s.length(); i++)  {
            	String next = prefix + s.charAt(i);
				String remaining = s.substring(0, i) + s.substring(i + 1);
				permute(next, remaining);
            }
        }
	}
	
	public static Set<String> getPermutations(String inputString) {

	    // base case
	    if (inputString.length() <= 1) {
	        return new HashSet<String>(Arrays.asList(inputString));
	    }

	    String allCharsExceptLast = inputString.substring(0, inputString.length() - 1);
	    char lastChar = inputString.charAt(inputString.length() - 1);

	    // recursive call: get all possible permutations for all chars except last
	    Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);

	    // put the last char in all possible positions for each of the above permutations
	    Set<String> permutations = new HashSet<String>();
	    for (String value : permutationsOfAllCharsExceptLast) {
	        for (int position = 0; position <= allCharsExceptLast.length(); position++) {
	            String permutation = value.substring(0, position) + lastChar + value.substring(position);
	            permutations.add(permutation);
	        }
	    }

	    return permutations;
	}

	public static void main(String[] args) {
		//PermutateString.permute("", "abcdefghij");
		Set<String> s = PermutateString.getPermutations("abc");
		System.out.println(s);
		System.out.println("Value "+ "aaa".substring(0,1));
		PermutateString.permute("", "abc");
	}

}
