package com.algorithms.sort;

public class QSort {
	
	public static void qsort(int arr[]) {
		
	}
	
	private static void qsort(int arr[], int si, int ei) {
		
	}
	
	private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int pe = a[lo];
        while (true) { 

            while (a[++i] < pe) {
                if (i == hi) break;
            }

            while (pe < a[--j]) {
                if (j == lo) break;
            }

            // check if pointers cross
            if (i >= j) break;

            exchange(a, i, j);
        }

        exchange(a, lo, j);

        return j;
    }

	private static void exchange(int arr[], int s, int d) {
		int temp = arr[s];
		arr[s] = arr[d];
		arr[d] = temp;
	}
	public static void main(String[] args) {
		int arr[] = {2,1,4,6,3,0,8,-1};
		partition(arr, 0, arr.length-1);
	}

}
