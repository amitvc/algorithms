package com.algorithms.arrays;

public class PrintMatrixDiagonally {
	
	public static void printMatrixDiagonally(int arr[][]) {
		int rowCount = arr.length;
		int colCount = arr[0].length;
		int result[][] = new int[rowCount+colCount-1][(rowCount+colCount-1)/2];
		for(int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			int row = rowIndex;
			int col = 0;
			while(col < colCount && row >= 0) {
				result[rowIndex][col] = arr[row][col];
				row--;
				col++;
			}
		}
		System.out.println(arr);
		int nextRow = rowCount;
		for(int colIndex=1; colIndex < colCount; colIndex++) {
			int row = rowCount-1;
			int col = colIndex;
			int colIdx =0;
			while(col < colCount && row >= 0) {
				result[nextRow][colIdx] = arr[row][col];
				row--;
				col++;
				colIdx++;
			}
			nextRow++;
		}
		
		System.out.println(arr.toString());

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { {1, 2, 3, 4},
                		{5, 6, 7, 8},
                		{9, 10, 11, 12},
                		{13, 14, 15, 16},
                		{17, 18, 19, 20}, };
		
		printMatrixDiagonally(arr);
		
	}

}
