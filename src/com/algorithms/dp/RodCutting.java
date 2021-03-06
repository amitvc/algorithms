package com.algorithms.dp;

class RodCutting {
	// A utility function to get the maximum of two integers
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}


	/*
	 * Returns the best obtainable price for a rod of length n and price[] as
	 * prices of different pieces
	 */
	static int cutRod(int price[], int n) {
		int val[] = new int[n + 1];
		val[0] = 0;
		int i, j;

		// Build the table val[] in bottom up manner and return the last entry
		// from the table
		for (i = 1; i <= n; i++) {
			int max_val = Integer.MIN_VALUE;
			for (j = 0; j < i; j++) {
				max_val = max(max_val, price[j] + val[i - j - 1]);
			}
			val[i] = max_val;
		}

		return val[n];
	}
	
	/*
	 * Returns the best obtainable price for a rod of length n and price[] as
	 * prices of different pieces
	 */
	static int cutRod2(int price[], int n) {
		int val[] = new int[n];
		val[0] = price[0];
		int i, j;

		// Build the table val[] in bottom up manner and return the last entry
		// from the table
		for (i = 1; i < n; i++) {
			int max_val = Integer.MIN_VALUE;
			for (j = 0; j <= i; j++) {
				int current_price = i -j -1 < 0 ? 0 : val[i-j-1];
				max_val = max(max_val, price[j] + current_price);
			}
			val[i] = max_val;
		}
		return val[n-1];
	}

	static int cutRodRecursive(int price[], int n) {
		if (n <= 0)
			return 0;
		int max_val = Integer.MIN_VALUE;
		// Recursively cut the rod in different pieces and compare different
		// configurations
		for (int i = 0; i < n; i++) {
			//System.out.println("Max_Val (bf) " + max_val);
			int nextItr = n -i -1;
			max_val = max(max_val, price[i] + cutRodRecursive(price, nextItr));
		}
		return max_val;
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		int arr[] = new int[] {1,5,8};
		int choice[] = new int[arr.length];
		System.out.println("Maximum Obtainable Value is " + cutRodRecursive(arr, arr.length));
		System.out.println(cutRod(arr, arr.length));
		
		System.out.println("Maximum Obtainable Value is " + cutRod(arr, arr.length));
		System.out.println("Maximum Obtainable Value is " + cutRod2(arr, arr.length));


	}
}