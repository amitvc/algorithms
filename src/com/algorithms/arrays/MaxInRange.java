package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxInRange {
	
	public static void maxInRange(int arr[], int k) {
	      List<Integer> result = new ArrayList<>();
	      for(int i=0; i < arr.length -k+1; i++) {
	       
	        int max = Integer.MIN_VALUE;
	        for(int j=i; j < i+k; j++) {
	            max = Math.max(max, arr[j]);        
	        }
	        
	        result.add(max);      
	      }
	    
	    System.out.println(result);
	    
	    Deque<Integer> dq = new LinkedList<>();	    
	  }
	
	public static void main(String[] args) {
	      int arr[] = {5,2,7,8,15,25,48,51};
	      maxInRange(arr,3);    
	     
	  }

}
