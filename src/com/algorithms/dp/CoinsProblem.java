package com.algorithms.dp;

import java.util.Arrays;

public class CoinsProblem {

	public static int calculateMinCoins(int weights[], int sum) {
		int minCoins[] = new int[sum + 1]; // array of DP results (k); look
											// above
											// for the example;

		minCoins[0] = 0; // base of DP: 0 weight can be achieved by 0 coins
		for (int P = 1; P <= sum; P++) { // iterate through all the states
			int minCnt = Integer.MAX_VALUE;
			for (int i = 0; i < weights.length; i++) {
				if (weights[i] <= P) {
					minCnt = Math.min(minCnt, minCoins[P - weights[i]] + 1);
				}
			}
			minCoins[P] = minCnt; // store the result in mink array
		}
		return minCoins[sum];
	}

	// 1,3,5 = Target =15 ---- Build array of size 16. arr[0] =0; minCoins[5] =
	// 5- 1 +1, 5-3 + 1, 5-5 +1

	static int minCoins(int coins[], int V) {
		// base case
		if (V == 0)
			return 0;

		// Initialize result
		int res = Integer.MAX_VALUE;
		
		for(int coin : coins) {
			if(V - coin >= 0) {
				res = Math.min(1+minCoins(coins, V-coin), res);				
			}
		}
		return res;
	}

	public static int minCoinsRec(int [] coins, int amount) {

		if(amount == 0) {
			return 0;
		}

		int result = Integer.MAX_VALUE;


		for(int i=0; i < coins.length; i++) {

			if (amount >= coins[i]) {
				result =  Math.min(result, 1+minCoinsRec(coins, amount - coins[i]));
			}
		}

		return result;
	}
	
	/**
	 * Bottom up way of solving this problem. Keep input sorted. Otherwise
	 * temp[j-arr[i]) + 1 can become Integer.Max_value + 1 which can be very low
	 * negative number Returns Integer.MAX_VALUE - 1 if solution is not
	 * possible.
	 */
	public static int minimumCoinBottomUp(int total, int coins[]) {
		int T[] = new int[total + 1];
		int R[] = new int[total + 1];
		T[0] = 0;
		for (int i = 1; i <= total; i++) {
			T[i] = Integer.MAX_VALUE - 1;
			R[i] = -1;
		}
		for (int j = 0; j < coins.length; j++) {
			for (int i = 1; i <= total; i++) {
				if (i >= coins[j]) {
					if (T[i - coins[j]] + 1 < T[i]) {
						T[i] = 1 + T[i - coins[j]];
						R[i] = j;
					}
				}
			}
		}
		printCoinCombination(R, coins);
		return T[total];
	}

	private static void printCoinCombination(int R[], int coins[]) {
		if (R[R.length - 1] == -1) {
			System.out.print("No solution is possible");
			return;
		}
		int start = R.length - 1;
		System.out.print("Coins used to form total ");
		while (start != 0) {
			int j = R[start];
			System.out.print(coins[j] + " ");
			start = start - coins[j];
		}
		System.out.print("\n");
	}

	public static int coinChangeWays(int[] coins, int amount, int index) {
		if (amount == 0) {
			return 1;
		}
		if (amount < 0) {
			return 0;
		}
		if (index > coins.length - 1)
			return 0;
		int ways = coinChangeWays(coins, amount - coins[index], index) + coinChangeWays(coins, amount, index + 1);
		return ways;
	}
	
	
	public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

	public static void main(String[] args) {
		int[] coins = { 1, 5,6 };
		int[] coins2 = { 1, 2, 5};
		calculateMinCoins(coins,13);
		System.out.println(minCoins(coins, 13));
		System.out.println(minCoinsRec(coins, 13));

		System.out.println("BottomUpMinCoins " + calculateMinCoins(coins, 15));
		System.out.println(change(5,coins2));
		System.out.println("BottomUpMinCoins " + minimumCoinBottomUp(9,coins2));


	}

}
