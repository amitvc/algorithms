package com.algorithms.practice2022.dynamicprogramming;

public class KnapSack {


    public static int maxProfit(int[] profits, int[] weights, int capacity) {
        return maxProfit(profits, weights, 0, capacity);
    }

    private static int maxProfit(int[] profits, int[] weights, int ci, int capacity) {

        // base case

        if (ci >= profits.length || capacity <= 0) {
            return 0;
        }

        int profitWithCI = 0;
        if (weights[ci] <= capacity) {
            profitWithCI = profits[ci] + maxProfit(profits, weights, ci+1, capacity - weights[ci]);
        }

        //exclude this item
        int profitWOCi = maxProfit(profits, weights, ci+1, capacity);

        return Math.max(profitWithCI, profitWOCi);
    }

    public static int maxProfitBU(int[] profits, int[] weights, int totalCapacity) {
        /**
         *  rows equal to the total number of items
         *  cols equal to current profit at that weight
         */
        int[][] solutions = new int[weights.length+1][totalCapacity+1];

        for (int item = 1; item <= profits.length; item++) {

            int currProfit = profits[item-1],  currWeight = weights[item-1];

            for (int capacity = 1; capacity <= totalCapacity; capacity++) {

                solutions[item][capacity] = solutions[item-1][capacity];

                if (capacity >= currWeight) {
                    solutions[item][capacity] = Math.max(solutions[item][capacity],
                                                         currProfit + solutions[item-1][capacity-currWeight]);
                }
            }
        }
        return solutions[profits.length][totalCapacity];
    }


    public static int maxProfitBU2(int[] profits, int[] weights, int totalCapacity) {
        int[][] dp = new int[profits.length][totalCapacity+1];

        for (int i=0; i <= totalCapacity; i++) {
            if (weights[0] <= i) {
                dp[0][i] = profits[0];
            }
        }

        for (int item = 1; item < profits.length; item++) {
            for (int col = 0; col <= totalCapacity; col++) {
                if (col ==0) continue;

                int profitWOCI = dp[item-1][col];

                int profitWCI = 0;
                if (col >= weights[item]) {
                    profitWCI = profits[item] + dp[item][col - weights[item]];
                }
                dp[item][col] = Math.max(profitWOCI, profitWCI);
            }
        }

        return dp[profits.length-1][totalCapacity];
    }

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = maxProfit(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = maxProfit(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);

        maxProfit = maxProfitBU(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = maxProfitBU(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);


        maxProfit = maxProfitBU2(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = maxProfitBU2(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);

    }
}
