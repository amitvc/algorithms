package com.algorithms.backtracking;

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
		int n = s.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
            	permute(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
        }
	}

	
	public static void main(String[] args) {
		//PermutateString.permute("", "abcdefghij");
		PermutateString.perm2("abcd");
	}

}
