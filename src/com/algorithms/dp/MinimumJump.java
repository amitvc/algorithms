package com.algorithms.dp;

import java.util.Map;

public class MinimumJump {
	
	public static int minJumps(int arr[], int l, int h)
	{
	   // Base case: when source and destination are same
	   if (h == l)
	     return 0;
	 
	   // When nothing is reachable from the given source
	   if (arr[l] == 0)
	     return Integer.MAX_VALUE;
	 
	   // Traverse through all the points reachable from arr[l]. Recursively
	   // get the minimum number of jumps needed to reach arr[h] from these
	   // reachable points.
	   int min = Integer.MAX_VALUE;
	   for (int i = l+1; i <= h && i <= l + arr[l]; i++)
	   {
	       int jumps = minJumps(arr, i, h);
	       if(jumps != Integer.MAX_VALUE && jumps + 1 < min)
	           min = jumps + 1;
	   }
	 
	   return min;
	}
	
	public static int jump(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        return jump(A, 0);
    }

    private static int jump(int[] A, int index) {
        if (index >= A.length - 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= A[index]; i++) {
            min = Math.min(min, 1 + jump(A, index + i));
        }
        return min;
    }

    
    public static int jumpLinear(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        int steps = 0;
        int distance = 0;
        int update = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (i + A[i] > distance) {
                distance = i + A[i];
            }
            if (i == update) {
                steps++;
                update = distance;
                if (distance >= A.length - 1) {
                break;
            }
            }
        }
        return steps ;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {50, 4,3,7,1 ,2,6,7,6,10};
		System.out.println(jump(arr));
	}

}
