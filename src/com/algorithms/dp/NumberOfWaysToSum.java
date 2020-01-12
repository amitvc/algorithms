package com.algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfWaysToSum {

    public static int ways(int arr[], int target, int idx) {

        if (target <= 0) {
            return 1;
        }

        int count = 0;
        for(int i=idx; i < arr.length; i++) {
            if (arr[i] <= target) {
                count += ways(arr, target-arr[i], i) + ways(arr, target, i+1);
            }
        }
        return count;
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){

        if (remain < 0) return;
        if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void main(String args[]) {
        int arr[] = {1,2,3};
        System.out.println("Ways "+ ways(arr, 4, 0));
        List<List<Integer>>  r =  combinationSum(arr, 4);
        System.out.println(r);
    }

}
