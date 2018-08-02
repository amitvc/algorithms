package com.algorithms.sort;

import java.util.LinkedHashMap;
import java.util.Map;

public class QSrt {
    
    /**
     *         [2,5,7,1,22,12,46,21,20,14]
     * 
     * 
     * 
     */
    
    public static void qsort(int arr[]) {
        qsort(arr, 0, arr.length-1);
    }
    
    private static void qsort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int pivot = partition(arr, si, ei);
        qsort(arr, si, pivot-1);
        qsort(arr, pivot+1, ei);
    }
    
    private static int partition(int[] a, int lo, int hi) {
        int pivot_element = a[lo];
        int left = lo+1;
        int right = hi;
        
        while(true) {
            while(left < hi) {
                if(!(a[++left] < pivot_element)) {
                    break;
                }
            }
            
            while(right > lo) {
                if(!(a[--right] >= pivot_element)) {
                    break;
                }
            }
            
            if(left > right) break;
            swap(a, left, right);
        }
        swap(a, right, lo);
        return right;
    }
    
    private static void swap(int arr[], int s, int d) {
        int t = arr[s];
        arr[s] = arr[d];
        arr[d] = t;
    }

    public static void main(String[] args) {
        int arr[] = {4,1,5,7,9,0,2,56};
        partition(arr, 0, arr.length);
    }
}