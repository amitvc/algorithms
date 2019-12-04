package com.algorithms.dp;

public class MaxLISSum {

    public static int sum;

    public static int maxLISSum(int arr[]) {
        return  helper(arr,0,0, Integer.MIN_VALUE);
    }

    public static int helper(int arr[], int currentIndex, int currentSum, int previousValue) {

        if (currentIndex >= arr.length){
            sum = Math.max(currentSum, sum);
            return currentSum;
        }

        if (arr[currentIndex] > previousValue) {
            return  Math.max(helper(arr, currentIndex+1, currentSum+arr[currentIndex], arr[currentIndex]),
                    helper(arr, currentIndex+1, currentSum, previousValue));
        } else {
            return helper(arr, currentIndex+1, currentSum, previousValue);
        }
    }




    public static void main(String[] args) {
        int arr[] = {8,12,2,3,15,5,7} ;
        System.out.println("Result " + maxLISSum(arr));
        int arr2[] = {10,70,20,30,50,11,30};
        System.out.println("Result " + maxLISSum(arr2));

    }
}
