package com.algorithms.dp;

public class CoinsProblem {

	public static int calculateMinCoins(int weights[], int sum) {
		int minCoins[] = new int[sum + 1]; // array of DP results (k); look above
										// for the example;

		minCoins[0] = 0; // base of DP: 0 weight can be achieved by 0 coins
		for (int P = 1; P <= sum; P++) { // iterate through all the states
			int minCnt = Integer.MAX_VALUE;
			for (int i = 0; i < weights.length; i++) {
				if (weights[i] <= P) {
					int cnt = minCoins[P - weights[i]] + 1;
					if (minCnt > cnt) {
						minCnt = cnt;
					}
				}
			}
			minCoins[P] = minCnt; // store the result in mink array
		}
		return minCoins[sum];
	}

	static int minCoins(int coins[], int V) {
		// base case
		if (V == 0) {
			return 0;
		}

		// Initialize result
		int min = Integer.MAX_VALUE;

		// Try every coin that has smaller value than V
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= V) {
				min = Math.min(min,minCoins(coins, V - coins[i])) +1;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[] coins = { 1, 3, 5 };
		System.out.println(calculateMinCoins(coins, 10));
		System.out.println(minCoins(coins, 11));
	}

}
