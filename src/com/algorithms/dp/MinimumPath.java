package com.algorithms.dp;

public class MinimumPath {
	
	public static int minPath(int arr[][], int n) {
		for(int i=1; i< n; i++) {
			arr[i][0] += arr[i-1][0];
		}
		
		for(int i=1; i< n; i++) {
			arr[0][i] += arr[0][i-1];
		}
		
		for(int i=1; i < n ;i++) {
			for(int j=1; j < n; j++) {
				arr[i][j] += Math.min(arr[i-1][j-1],Math.min(arr[i][j-1], arr[i-1][j]));
			}
		}
		return arr[n-1][n-1];
	}
	
	
	public static int minPathRec(int arr[][], int n) {
		
		return minPathHelper(arr, n, 0, 0);
	}
	
	private static int minPathHelper(int arr[][], int n, int x, int y) {
		if(x == n-1 && y == n-1) {
			return arr[x][y];
		}
		
		if(x == n || y == n) {
			return Integer.MAX_VALUE;
		}
		
		return arr[x][y] + Math.min(minPathHelper(arr, n, x+1, y+1), Math.min(minPathHelper(arr, n, x+1, y), minPathHelper(arr, n, x, y+1)));
	}

	public static void main(String[] args) {
		int arr[][] = new int[3][3];
		arr[0][0] = 4;
		arr[0][1] = 3;
		arr[0][2] = 2;
		
		arr[1][0] = 1;
		arr[1][1] = 8;
		arr[2][2] = 3;
	
		arr[2][0] = 1;
		arr[2][1] = 1;
		arr[2][2] = 8;
		//System.out.println(minPath(arr,3));
		System.out.println(minPathRec(arr,3));
	}

}
