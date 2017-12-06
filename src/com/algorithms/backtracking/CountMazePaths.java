package com.algorithms.backtracking;

public class CountMazePaths {
	
	public static boolean isCellValid(int row, int col, int size) {
		if(row <0 || col < 0 || row >= size || col >= size) return false;
		return true;
	}

	
	public static int countPath(int arr[][], int size, int row, int col, boolean visited[][]) {
		int path = 0;
		if(row == size-1 && col == size-1) {
			return 1;
		} else {
			if(isCellValid(row, col,size) && arr[row][col] == 1) {
				visited[row][col] = true;
				if(isCellValid(row+1,col,size) && !visited[row+1][col]) {
					path += countPath(arr, size, row+1,col, visited);
				}
				if(isCellValid(row-1, col, size) && !visited[row-1][col]) {
					path += countPath(arr, size, row-1,col, visited);
				}
				if(isCellValid(row,col+1,size) && !visited[row][col+1]) {
					path += countPath(arr, size, row,col+1, visited);
				}
				if(isCellValid(row, col-1, size) && !visited[row][col-1]) {
					path += countPath(arr, size, row,col-1, visited);
				}
			}
		}
		return path;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maze[][] = 
			{
				{ 1, 1, 1, 1 },
				{ 1, 1, 0, 1 },
				{ 0, 1, 0, 1 },
				{ 1, 1, 1, 1 }
			};
		
		boolean visited[][] = new boolean[4][4];
		System.out.println(countPath(maze, 4, 0, 0, visited));

	}

}
