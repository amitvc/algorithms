package com.algorithms.dp;

public class MinJumpArrayBottomUp {

    public static int minJumpRecursive(int arr[]) {

        return minJumpRec(arr, 0);

    }

    public static int minJumpRec(int arr[], int startingIndex) {

        if (startingIndex >= arr.length) {
            return 0;
        }

        int ans = 9999;
        for(int j=1; j <= arr[startingIndex]; j++) {
            ans  = Math.min(ans, minJumpRec(arr, startingIndex+j)) +1;
        }
        return ans;
    }





    public static void main(String[] args) {

        //int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int arr[] = {1,3,0,0,2,1,0,100};

        System.out.println("MinJump " + minJumpRecursive(arr));
    }
}
