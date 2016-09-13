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
		if(n < 10) {
			return n;
		} else {
			return digitSum(n/10) + n%10;
		}
	}
	
	
	public static boolean recSubset(int[] a, int target, int i, int sumSoFar) {
		
		//System.out.println("i : "+ i + " sf : "+ sumSoFar + " a[i] : " + (i >= a.length ? "none" : a[i]));
		if (sumSoFar == target) return true;
		
		
		if (i == a.length || sumSoFar > target) return false;
		boolean with = recSubset(a, target, i+1, sumSoFar + a[i]);
		boolean without = recSubset(a, target, i+1, sumSoFar);
		return (with || without);
	}	
	
	public static void main(String[] args) {
		int a[] = {22,2,33};
		//System.out.println(sum(a, a.length, 35));
		
		System.out.println(recSubset(a, 35, 0, 0));
		printInteger(1425);
		System.out.println("\n" + digitSum(999121221));
	}

}
