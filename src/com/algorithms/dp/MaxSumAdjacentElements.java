package com.algorithms.dp;

public class MaxSumAdjacentElements {

	public static int maxSum(int[] arr, int i) {
		if(i==0) {
			return arr[i];
		} else if(i == 1) {
			return Math.max(arr[0], arr[1]);
		}
		
		return Math.max(maxSum(arr, i-1), arr[i] + maxSum(arr, i-2));
	}
	
	
	public static int FindMaxSum(int arr[], int n)
	{
	  int incl = arr[0];
	  int excl = 0;
	  int excl_new;
	  int i;
	 
	  for (i = 1; i < n; i++)
	  {
	     /* current max excluding i */
	     excl_new = (incl > excl)? incl: excl;
	 
	     /* current max including i */
	     incl = excl + arr[i];
	     excl = excl_new;
	  }
	 
	   /* return max of incl and excl */
	   return ((incl > excl)? incl : excl);
	}
	
	
	public static int maxSumBottomUp(int arr[]) {
		
		int temp[] = {arr[0],arr[1]};
		
		for(int i=2;i< arr.length;i++){
			int tempp = temp[1];
			temp[1] = temp[0]+arr[i];
			temp[0] = Math.max(temp[0],tempp);
		}
		
		return Math.max(temp[0], temp[1]);
		
		
	}
	
	
	public static void main(String[] args) {
		int arr[] = { 12,300,12,22};
		int result = maxSum(arr, arr.length-1);
		System.out.println("MaxSum Adjacent " + result);
		result = FindMaxSum(arr, arr.length);
		System.out.println("MaxSum Adjacent " + result);
		System.out.println("MaxSum "+ maxSumBottomUp(arr));
 	}

}
