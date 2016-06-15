package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// List 0 - 1,2,3
// List 1 - 4,5,6
// List 2 - 7,8,9

public class SpiralArrayPrint {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> spiralOrder(final List<List<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 boolean left = true;
		 boolean right = false;
	     boolean top = false;
	     boolean down = false;
	     int lci = 0;
	     int rci = a.get(0).size() -1;
	     int tri = 0;
	     int bri = a.size() -1;
	     int N = a.size() * a.get(0).size();
	     
	     int scanCount = 0;
	     while(scanCount < N) {
	    	 if(left == true) {
	    		 List<Integer> row = a.get(tri);
	    		 for(int i=lci; i <= rci;i++) {
	    			 Integer val = row.get(i);
	    			 result.add(val);
	    			 scanCount++;
	    		 }
	    		 left = false;
	    		 down = true;
	    		 tri++;
	    	 } else if(down == true) {
	    		 for(int i = tri; i <= bri; i++) {
	    			 List<Integer> row = a.get(i);
	    			 Integer val = row.get(rci);
	    			 result.add(val);
	    			 scanCount++;
	    		 }
	    		 right = true;
	    		 down = false;
	    		 rci--;
	    	 } else if(right == true) {
	    		 List<Integer> row = a.get(bri);
	    		 for(int i=rci; i >= lci; i--) {
	    			 Integer val = row.get(i);
	    			 result.add(val);
	    			 scanCount++;
	    		 }
	    		 right = false;
	    		 top = true;
	    		 bri--;
	    	 } else if(top == true) {
	    		 for(int i= bri; i >= tri; i--) {
	    			 List<Integer> row = a.get(i);
	    			 Integer val = row.get(lci);
	    			 result.add(val);
	    			 scanCount++;
	    		 }
	    		 top = false;
	    		 left = true;
	    		 lci++;
	    	 }
	     }
		 return result;
	}
	
	public static void main(String args[]) {
		Integer r1[] = {1,  2,  3,  4};
		Integer r2[] = {5,  6,  7,  8};
		Integer r3[] = {9,  10, 11, 12};
		Integer r4[] = {13, 14, 15, 16};
		List<Integer> lr1 =  Arrays.asList(r1);
		List<Integer> lr2 =  Arrays.asList(r2);
		List<Integer> lr3 =  Arrays.asList(r3);
		List<Integer> lr4 =  Arrays.asList(r4);

		List<List<Integer>> a = new ArrayList<>();
		a.add(lr1);
		a.add(lr2);
		a.add(lr3);
		a.add(lr4);

		SpiralArrayPrint p = new SpiralArrayPrint();
		p.spiralOrder(a);
		
	}
}
