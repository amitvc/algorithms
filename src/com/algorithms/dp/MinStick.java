package com.algorithms.dp;

import java.util.Arrays;

public class MinStick {

    public static int minStick(int arr[]) {
        int minStick = Integer.MAX_VALUE;

        if (arr.length == 2) {
            return arr[0] + arr[1];
        }

        for (int i=0; i < arr.length; i++) {
            int a1[] = Arrays.copyOfRange(arr,0,i);
            int a2[] = Arrays.copyOfRange(arr,i+1, arr.length);
            int result[] = combine(a1, a2);
            int cost =  minStick(result);
            int newCost = arr[i] + cost;
            minStick = Math.min(newCost+cost, minStick);
        }

        return minStick;
    }

    public static int[] combine(int a[], int b[]) {
        int[] result = new int[a.length + b.length];
        int pos = 0;
        for (int element : a) {
            result[pos] = element;
            pos++;
        }
        for (int element : b) {
            result[pos] = element;
            pos++;
        }

        return result;
    }


    public static void main(String[] args) {
        int arr[] = {1,8,3,5};
        System.out.println("Min Stick "+ minStick(arr));
    }
}
