package com.algorithms.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {


    public static int minMatMult(int []arr) {

        int cache[][] = new int[arr.length][arr.length];
        Arrays.stream(cache).forEach(e -> Arrays.fill(e,-1));
        return minMatMult(arr, cache, 1, arr.length-1);
    }


    public static int minMatMult(int arr[], int cache[][], int i, int j) {
        if (i==j) return 0;

        //if (cache[i][j] != -1) {
          //  System.out.println("Overlapping");
            //return cache[i][j];
        //}
        System.out.println(" I "+ i + " J "+j);

        int min = Integer.MAX_VALUE;

        for(int k=i; k < j; k++) {
            int ans =  minMatMult(arr, cache, i, k) + minMatMult(arr, cache, k+1, j) + arr[i-1]*arr[k]*arr[j];
            min = Math.min(ans, min);
        }

        cache[i][j] = min;
        return min;
    }


    public static void main(String args[]) {
        int arr[] = {1,2,3,4,5,6};
        int ans = minMatMult(arr);
        System.out.println("Ans " + ans);
    }

}
