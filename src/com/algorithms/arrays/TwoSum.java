package com.algorithms.arrays;


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	 public int[] twoSum(int[] nums, int target) {
	        int result[] = new int[2];
	        Map<Integer, Integer> lookup = new HashMap<>();
	        
	        for(int i=0; i < nums.length; i++) {
	        	int complement = target - nums[i];
	        	if(lookup.containsKey(complement)) {
	        		result [0] = lookup.get(complement);
	        		result[1] = i;
	        		return result;
	        	} else {
	        		lookup.put(nums[i] ,i);
	        	}
	        	
	        }
	        return result;
	        
	  }	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int a[] = {3,2,4};
		  TwoSum ts = new TwoSum();
		  int result[] = ts.twoSum(a, 6);
		  System.out.println(result[0] + ", " + result[1]);

	}

}
