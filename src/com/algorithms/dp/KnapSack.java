package com.algorithms.dp;

public class KnapSack {
	
	public static int knapSack(int currentWeight, int [] weights, int [] value, int i) {
		if(currentWeight == 0 || i == weights.length) {
			return 0;
		} else {
			if(currentWeight < weights[i]) {
				return knapSack(currentWeight, weights, value, i+1); //dont include this item since it exceeds the capacity.
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


	public static int maxValue(int weights[], int value[], int capacity) {

		int dp[][] = new int[weights.length+1][capacity+1];


		for(int i=0; i <= weights.length; i++) {

			for(int w=0; w <= capacity; w++) {

				if(i ==0 || w == 0) {

					dp[i][w] = 0;
				} else if (weights[i-1] <= w) {
						dp[i][w] = Math.max(value[i-1] + dp[i-1][w - weights[i-1]], dp[i-1][w]);
					} else {
					  dp[i][w] = dp[i-1][w];
				}

			}
		}


		return dp[weights.length][capacity];

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = new int[]{1, 10, 12};
        int wt[] = new int[]{1, 2, 3};
        int  W = 5;
		maxValue(wt, val, W);
		bottomUpKnapSack(W, wt, val);
		System.out.println(knapSack(3,wt, val,0));
	}

}
