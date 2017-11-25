package com.algorithms.backtracking;

public class JumpToEndOfArray {

	static int minJumps(int arr[], int l, int h) {
		// Base case: when source and destination are same
		if (h == l)
			return 0;

		// When nothing is reachable from the given source
		if (arr[l] == 0)
			return Integer.MAX_VALUE;

		// Traverse through all the points reachable from arr[l]. Recursively
		// get the minimum number of jumps needed to reach arr[h] from these
		// reachable points.
		int min = Integer.MAX_VALUE;
		for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {
			min = Math.min(min, minJumps(arr, i, h) + 1);
		}

		return min;
	}

	/**
	 * {1,4,2,1,0,5}
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 4, 3, 7, 1, 2, 6, 7, 6, 10 };
		int minJumps = minJumps(arr, 0, arr.length - 1);
		System.out.println(minJumps);
	}

}
