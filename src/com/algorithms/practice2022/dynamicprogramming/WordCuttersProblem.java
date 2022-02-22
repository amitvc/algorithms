package com.algorithms.practice2022.dynamicprogramming;

import java.util.Arrays;

public class WordCuttersProblem {

    public static int maxProfit(int sp[], int length) {
        if (length <= 0) {
            return 0;
        }
        int maxProfit = 0;
        for(int i=0; i < length; i++) {
            maxProfit = Math.max(maxProfit, sp[i] + maxProfit(sp, length - i -1));
        }
        return maxProfit;
    }

    public static int maxProfit(int profits[]) {
        int profitByCutLength[] = new int[profits.length+1];

        Arrays.fill(profitByCutLength, 0);

        for (int i=0; i < profits.length; i++) {

            int maxProfit = -1;
            for (int j =0; j <= i; j++) {
                int cutLength = i -j;
                maxProfit = Math.max(maxProfit, profits[j] + profitByCutLength[cutLength]);
            }
            profitByCutLength[i+1] = maxProfit;
        }

        return profitByCutLength[profitByCutLength.length-1];
    }

    public static void main(String[] args) {
        int profits[] = {3,5,8};
       // System.out.println(maxProfit(profits, 4));

        System.out.println(maxProfit(profits));

    }
}
