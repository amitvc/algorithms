package com.algorithms.arrays;

public class QuickSelect {
	
	// [3,1,4,5,2,6,9]
	// [3,1,2,5,4,6,9]
	//

	public static int partition(int arr[], int left, int right) {
		int pivotElement = arr[left];
		int l = left;
		int r = right;
		
		while(true) {
			while(arr[++l] < pivotElement) {
				if(l == right) break;
			}
			
			while(arr[--r] > pivotElement)  {
				if(r == left) break;
			}
			
			if(l >= r) break;
			swap(arr,l,r);
		}
		swap(arr, left, r);
		return r;
	}
	
	private static void swap(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
		
	}

	public static void main(String[] args) {
		int arr[] = {7,8,4,5,2,6,9};
		int j = partition(arr, 0, arr.length);
		System.out.println(j);
	}

}
