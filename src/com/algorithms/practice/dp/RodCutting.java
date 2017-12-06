package com.algorithms.practice.dp;

/**
 * Problem state - Given a rod of size S inches find the optimal way to cut the
 * rod to maximize the profit. The rod can be cut into 1 inch, 2 inch...,S
 * inches. Each cut has associated with it a profit value. We need to find how
 * to cut the rod so that we get max profit.
 * 
 * E.g Rod of size 3 with cut_profits = {3,2,6} So in this case the max profit
 * is by cutting rod with 1 inch cuts, {1,1,1} ==> {3,3,3} ==> 9 The second best
 * cut if to not cut the rod at {3} ==> {6} ==> 6 Third best is {1,2} ==> {3,2}
 * ==> 5 So the intuition behind this profile is to find the best case cut --
 * 
 * MaxRodCutProfit(N) -- Max( profit[1] + MaxRodCutProfit(N-1), profit[2] +
 * MaxRodCutProfit(N-2),...profit[N] + MaxRodCutProfit(N-N)) There is clear
 * recurrence relationship that we can establish and use it to our advantage to
 * solve the problem.
 * 
 * @author amit
 */
public class RodCutting {

	public static int maxProfitRecursive(int N, int profit[]) {
		if (N <= 0) {
			return 0;
		}

		int maxProfit = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			maxProfit = Math.max(maxProfit, profit[i] + maxProfitRecursive(N - 1 - i, profit));
		}
		return maxProfit;
	}

	public static int maxRodCuttingBU(int N, int profit[]) {
		int maxProfit[] = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			int max_val = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				max_val = Math.max(max_val, profit[j] + maxProfit[i - j - 1]);
			}
			maxProfit[i] = max_val;
		}
		return maxProfit[N];
	}

	public static void main(String[] args) {
		int profit[] = { 5,2 };
		System.out.println(maxProfitRecursive(profit.length, profit));
		System.out.println(maxRodCuttingBU(profit.length, profit));

	}

}
