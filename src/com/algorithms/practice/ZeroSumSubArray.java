package com.algorithms.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroSumSubArray {
	
	
	public static List<Integer> subArrayZeroSum(int values[]) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> lookup = new HashMap<>();
		
		int sum = 0;
		for(int i=0; i < values.length;i++) {
			sum += values[i];
			
			if(lookup.containsKey(sum) || sum == 0) {
				for(int j=lookup.get(sum)+1; j <=i;j++) {
					result.add(values[j]);
				}
				break;
			} else {
				lookup.put(sum, i);
			}
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		int arr[] = {4, 2, -3, 1, 6};
		int arr1[] ={1, 4, -2, -2, 5, -4, 3};
		int negArr[] ={-3, 2, 3, 1, 6};
		System.out.println(ZeroSumSubArray.subArrayZeroSum(arr).toString());
		System.out.println(ZeroSumSubArray.subArrayZeroSum(negArr).toString());
		System.out.println(ZeroSumSubArray.subArrayZeroSum(arr1).toString());

	}

}
