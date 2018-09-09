package com.algorithms.practice;

public class MinPathMatrix {
	
	
	public static int minPath(int [][] source, int destRow, int destCol) {
		if(destCol < 0  || destRow < 0) {
			return Integer.MAX_VALUE;
		}
		if(destRow == 0 && destCol ==0) {
			return source[destRow][destCol];
		}
		
		return source[destRow][destCol] + Math.min( minPath(source, destRow-1, destCol), minPath(source, destRow, destCol-1));
	}
	
	public static int minPathBottomUp(int source[][], int destRow, int destCol) {
		int path[][] = new int[destRow+1][destCol+1];
		
		path[0][0] = source[0][0];
		
		/**
		 *    a,b,c
		 *    x,x,x
		 *    x,x,x
		 * 
		 * 
		 */
		for(int i=1; i <= destCol; i++) {
			path[0][i] = path[0][i-1] + source[0][i];
		}
		
		for(int i=1; i <= destRow; i++) {
			path[i][0] = path[i-1][0] + source[i][0];
		}
		
		for(int row= 1; row <= destRow; row++) {
			for(int col= 1; col <= destCol; col++) {
				path[row][col] = source[row][col] + Math.min(path[row-1][col], path[row][col-1]);
			}
		}
		
		return path[destRow][destCol];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int source[][] = {  {1, 2, 3},
							{3, 1, 2},
							{1, 5, 3} };
		int value =MinPathMatrix.minPath(source, 2, 2);
		System.out.println(value);
		System.out.println(MinPathMatrix.minPathBottomUp(source, 2, 2));
	}
}
