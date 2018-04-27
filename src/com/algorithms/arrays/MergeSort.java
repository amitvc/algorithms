package com.algorithms.arrays;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] input){
		// Write your code here
	   int aux[] = new int[input.length];
       sort(input, aux, 0, input.length-1);
	}
  
    public static void sort(int[] input, int [] aux, int si, int ei) {
       if(si >= ei) {
         return;
       }
       int mid = (si+ei)/2;
       sort(input,aux, si, mid);
       sort(input, aux, mid+1, ei);
       merge(input, aux, si, ei, mid);
    }
  
  
    public static void merge(int [] input, int [] aux, int si, int ei, int mid) {
       for(int i=si; i<=ei;i++) {
         //copy from input to aux
         aux[i] = input[i];
       }
      
      int siPtr = si;
      int midPtr = mid+1;
      for(int i=si; i <= ei; i++) {
        if(siPtr > mid) {
          input[i] = aux[midPtr++];
        } else if(midPtr > ei) {
          input[i] = aux[siPtr++];
        } else if(aux[siPtr] < aux[midPtr]) {
           input[i] = aux[siPtr++];
        } else {
          input[i] = aux[midPtr++];
        }
      }
    }
    
    public static void main(String args[]) {
    	int arr[] = {2,6,8,5,4,3,35};
    	mergeSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
