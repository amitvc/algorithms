package com.algorithms.dp;

public class RobHouses {

    public static int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }
    private static int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    }

    public static int rob_i(int arr[]) {
        return rob_i(arr, 0);
    }

    public static int rob_i(int arr[], int index) {
        if(index >= arr.length) {
            return 0;
        }

        return Math.max(arr[index] + rob_i(arr, index+2), rob_i(arr,index+1));
    }

    public static void main(String args[]) {
        int arr[] = {2,7,4,3,1};
        System.out.println("Total value " + rob(arr));
        System.out.println("Total value_i " + rob_i(arr));

    }
}
