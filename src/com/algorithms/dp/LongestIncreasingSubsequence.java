package com.algorithms.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static int LDS(int arr[], int i, int n, int prev) {
        // Base case: nothing is remaining
        if (i == n)
            return 0;

        // case 2: include the current element if it is smaller
        // than previous element in LDS
        int incl = 0;
        if (arr[i] < prev)
            incl = 1 + LDS(arr, i + 1, n, arr[i]);

        // case 1: exclude the current element and process the
        // remaining elements
        int excl = LDS(arr, i + 1, n, prev);

        // return maximum of above two choices
        return Math.max(incl, excl);
    }

    public static int lengthOfLISBU(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
    
    public static int lis(int [] nums) {
        int dp[] = new int[nums.length];
        dp[0] = 1;
        for(int i=1; i < nums.length;i++) {
            dp[i] = 1;
            for(int j=0; j < i; j++) {
                if(nums[j] > nums[i]) {
                    continue;
                }
                
                dp[i] = Math.max(dp[i],  dp[j]+1);
            }
        }
        int MAX = Integer.MIN_VALUE;
        for(int n : dp) {
            if( n > MAX) {
                MAX = n;
            }
        }
        return MAX;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr[] = { 0, 8, 4, 12, 2 };
        System.out.println(LDS(arr, 0, arr.length, Integer.MAX_VALUE));
        int arrs[] = { 0, 8, 4, 12, 2 };
        System.out.println(lengthOfLIS(arrs));
        System.out.println(lengthOfLISBU(arr));
        System.out.println(lis(arr));
    }

}
