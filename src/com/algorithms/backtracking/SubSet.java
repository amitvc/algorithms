package com.algorithms.backtracking;

public class SubSet {

	public static void printInteger(int n) {
		if (n < 10) {
			System.out.print((char) ('0' + n));
		} else {
			printInteger(n / 10);
			System.out.print((char) ('0' + n % 10));
		}
	}

	public static int digitSum(int n) {
		if (n < 10) {
			return n;
		} else {
			return digitSum(n / 10) + n % 10;
		}
	}

	static boolean isSubsetSum(int set[], int n, int sum) {
		// The value of subset[i][j] will be true if there
		// is a subset of set[0..j-1] with sum equal to i
		boolean subset[][] = new boolean[sum + 1][n + 1];

		// If sum is 0, then answer is true
		for (int i = 0; i <= n; i++)
			subset[0][i] = true;

		// If sum is not 0 and set is empty, then answer is false
		for (int i = 1; i <= sum; i++)
			subset[i][0] = false;

		// Fill the subset table in botton up manner
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];
				if (i >= set[j - 1])
					subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
			}
		}

		// uncomment this code to print table
		for (int i = 0; i <= sum; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print("\t"+subset[i][j]);
			}
			System.out.println("\n");
		}
		return subset[sum][n];
	}
	
	public static boolean isSubsetSums(int set[], int n, int sum) 
	{ 
	    // The value of subset[i][j] will be true if there is a  
	    // subset of set[0..j-1] with sum equal to i 
	    boolean subset[][] = new boolean[n+1][sum+1]; 
	   
	    // If sum is 0, then answer is true 
	    for (int i = 0; i <= n; i++) 
	      subset[i][0] = true; 
	   
	    // If sum is not 0 and set is empty, then answer is false 
	    for (int i = 1; i <= sum; i++) 
	      subset[0][i] = false; 
	   
	     // Fill the subset table in botton up manner 
	     for (int i = 1; i <= n; i++) 
	     { 
	       for (int j = 1; j <= sum; j++) 
	       { 
	         if(j<set[i-1]) 
	         subset[i][j] = subset[i-1][j]; 
	         if (j >= set[i-1]) 
	           subset[i][j] = subset[i-1][j] ||  // exclude
	                                 subset[i - 1][j-set[i-1]];  // include
	       } 
	     } 
	   
	     for (int i = 0; i <= n; i++) 
	     { 
	       for (int j = 0; j <= sum; j++) 
	          System.out.print("\t"+subset[i][j]); 
	        System.out.println("\n");
	     }
	   
	     return subset[n][sum]; 
	} 

	public static boolean recSubset(int[] a, int target, int i, int sumSoFar, String s) {

		// System.out.println("i : "+ i + " sf : "+ sumSoFar + " a[i] : " + (i
		// >= a.length ? "none" : a[i]));
		if (sumSoFar == target) {
			System.out.println(s);
			return true;
		}

		if (i == a.length || sumSoFar > target)
			return false;
		boolean with = recSubset(a, target, i + 1, sumSoFar + a[i], s+","+a[i]);
		boolean without = recSubset(a, target, i + 1, sumSoFar, s+"");
		return (with || without);
	}

	public static void main(String[] args) {
		int a[] = { 1,2,5 };
		// System.out.println(sum(a, a.length, 35));

		System.out.println(recSubset(a, 13, 0, 0,""));

		//System.out.println("isSubset " + isSubsetSum(a, a.length, 4));
		isSubsetSums(a, a.length, 6);
//		printInteger(1425);
//		System.out.println("\n" + digitSum(999121221));
	}

}
