package com.algorithms.arrays;

/**
 * Problem - 
 * Find min number of times you need to jump to get to the end of the array.
 * input = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * ans = 3
 * input = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5}
 * ans = 4 
 * 
 * @author achavan
 *
 */
public class MinJumpToEnd {
    
    public static int INF = Integer.MAX_VALUE;
    
    /**
     * @param arr
     * @return
     */
    public static int minJumpsRecursive(int arr[], int curr, int end) {
        if(curr == end) 
            return 0;
        if(arr[curr] == 0)
            return INF;
        int reach =  arr[curr];
        int min = INF;
        for(int i= curr+1; i <= curr+reach && i <=end; i++) {
            int jump = minJumpsRecursive(arr, i, end);
            if(jump < INF && jump < min) {
                min = jump + 1;
            }
        }        
        return min;
    }
    
    public static int minJump(int arr[]) {
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {2,0,1,3,0,0};
        int min = minJumpsRecursive(arr, 0, arr.length-1);
        System.out.println("min = "+min);
    }

}
