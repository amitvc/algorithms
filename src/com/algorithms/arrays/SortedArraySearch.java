package com.algorithms.arrays;

public class SortedArraySearch {

	public static boolean search(int arr[][], int rowCount, int colCount, int row, int col, int number) {
		if(row >= rowCount || col < 0) {
			return false;
		}
		if(arr[row][col] == number) {
			return true;
		}
		if(arr[row][col] > number) {
			return search(arr, rowCount, colCount, row, --col, number);
		} else {
			return search(arr, rowCount, colCount, ++row, col, number);
		}
	}
	
	public static boolean searchItr(int arr[][], int rowCount, int colCount, int number) {
		return false;
	}
	
	public static void main(String[] args) {
		int arr[][] = {
				{2,6,7,11},
				{3,8,10,12},
				{4,9,11,13},
				{5,15,16,18}
		};
		System.out.println(search(arr, 4,4, 0,3, 3));
	}

}
