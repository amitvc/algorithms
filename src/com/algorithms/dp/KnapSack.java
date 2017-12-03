package com.algorithms.dp;

public class KnapSack {
	
	public static int knapSack(int currentWeight, int [] weights, int [] value, int i) {
		if(currentWeight == 0 || i == weights.length) {
			return 0;
		} else {
			if(currentWeight < weights[i]) {
				return knapSack(currentWeight, weights, value, i+1);
			} else {
				return Math.max(value[i] + knapSack(currentWeight- weights[i], weights, value, i+1), 
						knapSack(currentWeight, weights, value, i+1));
			}
		}
	}
	
	public static int bottomUpKnapSack(int maxWeight, int [] weights, int []value) {
		int dp[][] = new int[value.length+1][maxWeight+1];
		
		for(int i=0; i <=value.length; i++) {
			for(int w=0; w <= maxWeight; w++) {
				if (i==0 || w==0)
	                  dp[i][w] = 0;
				else if (weights[i-1] <= w)
	                   dp[i][w] = Math.max(value[i-1] + dp[i-1][w-weights[i-1]],  dp[i-1][w]);
	             else
	                   dp[i][w] = dp[i-1][w];
			}
		}
		return dp[value.length][maxWeight];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = new int[]{600, 100, 720};
        int wt[] = new int[]{10, 20, 30};
        int  W = 30;
        System.out.println(knapSack(W, wt, val, 0));
        System.out.println(bottomUpKnapSack(W, wt, val));

	}

}
