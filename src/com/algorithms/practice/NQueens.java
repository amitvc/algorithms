package com.algorithms.practice;

/**
 * So basically this algorithm uses recursive backtracking strategy.
 * @author amit
 *
 */
public class NQueens {
	
	public static void nqueens(int arr[][], int col) {
		for(int row = 0; row < arr.length; row++) {
			if(safe(row, col, arr)){
				arr[row][col] = 1;
				if(col == arr.length-1) {
					print(arr);
					return;
				} else {
					nqueens(arr, col+1);
					arr[row][col] =0;
				}
			}
		}
	}
	
	public static boolean safe(int row, int col, int a[][]) {
		for(int i=0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				if(a[i][j] == 1) {
					if(row == i) return false;
					if(col == j) return false;
					if(Math.abs(row -i) == Math.abs(col-j)) return false;
				}
			}
		}
		return true;
	}
	
	public static void print(int arr[][]) {
		for(int i=0; i <  arr.length; i++) {
			for(int j=0; j < arr.length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 50;
		int arr[][] = new int[size][size];
		nqueens(arr, 0);
	}

}
