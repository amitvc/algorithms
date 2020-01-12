package com.algorithms.matrix;

import java.util.Arrays;

public class ConnectedIslands {

	public static int maxConnectedIslands(int arr[][], int n, int m) {
		boolean visited[][] = new boolean[n][m];
		//Arrays.fill(visited, false);
		int maxSize = Integer.MIN_VALUE;
		for(int i=0; i < n; i++) {
			for(int j=0; j < m; j++) {
				if(visited[i][j] == false) {
					maxSize = Math.max(maxSize, helper(arr, visited, i, j, n, m));
				}
			}
		}
		return maxSize;
	}
	
	
	public static int helper(int arr[][], boolean visited[][], int row, int col, int n, int m) {
		if(row >= n || col >= m || row < 0 || col < 0 || visited[row][col] == true || arr[row][col] == 0) {
			return 0;
		}
		visited[row][col] = true;
		return 1 + helper(arr, visited,row-1,col, n,m)   //
					+helper(arr, visited,row+1,col, n,m)
					+helper(arr, visited,row,col-1, n,m)
					+helper(arr, visited,row-1,col-1, n,m)
					+helper(arr, visited,row+1,col+1, n,m)
					+helper(arr, visited,row-1,col+1, n,m)
					+helper(arr, visited,row+1,col-1, n,m)
					+helper(arr, visited, row, col+1, n,m);
	}
	
	public static void main(String[] args) {

		int arr[][] = {
				{1,1,0,0,0},
				{1,1,1,0,0},
				{0,0,1,0,1},
				{1,0,0,0,1},
				{0,1,0,1,1}
				};
		
		System.out.println(maxConnectedIslands(arr,5,5));
	}

}
