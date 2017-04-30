package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddOne {

	public ArrayList<Integer> plusOne(List<Integer> a) {
		int len = a.size();
		boolean carryOver = true;
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i= len-1; i >=0; i--) {
			int val = a.get(i);
			
			val = carryOver == true ? val+1  : val;
			if(val%10 == 0 && val !=0) {
				result.add(val%10);

				carryOver = true;
			} else {
				result.add(val);	
				carryOver = false;
			}
			
		}
		if(carryOver) {
			result.add(1);
		}
		
		ArrayList<Integer> filterZeros = new ArrayList<>();
		boolean skip = true;
		Collections.reverse(result);

		for(Integer r : result) {
			if(skip == true) {
				System.out.println(r);

				if(r.compareTo(0) == 0) {
					System.out.println("Skipping "+r);
					continue;
				} else {
					skip = false;
					filterZeros.add(r);
				}
			} else {
				filterZeros.add(r);
			}
		}
		//Collections.reverse(filterZeros);
		return filterZeros;
	}

	
	public static void main(String[] args) {
		Integer a[] = {0,0, 3, 7, 6, 4, 0, 5, 5, 5};
		AddOne o = new AddOne();
		System.out.println(o.plusOne(Arrays.asList(a)));
	}

}
