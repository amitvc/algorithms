package com.algorithms.dp;

public class UniquePaths {
	
	public static int paths(int arr[][], int n) {
		return pathHelper(arr, n, 0, 0);
	}
	
	public static int pathHelper(int arr[][], int n, int x, int y) {
		if(x == n-1 && y == n-1) return 1;
		if(x<n-1 && y<n-1){
	        return pathHelper(arr, n, x+1,y) + pathHelper(arr, n, x, y+1);
	    }
	 
	    if(x<n-1){
	        return  pathHelper(arr, n, x+1, y);//pathHelper(i+1,j,m,n);
	    }
	 
	    if(y<n-1){
	        return pathHelper(arr, n, x, y+1);
	    }
	 
	    return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = new int[3][3];
		arr[0][0] = 0;
		arr[0][1] = 0;
		arr[0][2] = 0;
		
		arr[1][0] = 0;
		arr[1][1] = 1;
		arr[2][2] = 0;
	
		arr[2][0] = 0;
		arr[2][1] = 0;
		arr[2][2] = 0;
		System.out.println(paths(arr,3));
	}

}
