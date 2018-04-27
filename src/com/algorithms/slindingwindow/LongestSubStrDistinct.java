package com.algorithms.slindingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrDistinct {

	//"findlongeststr";
	
	public static int lengthOfLongestSubstring(String s) {
       int ans = 0;
       Map<Character, Integer> cache = new HashMap<>();
       int newLeft = 0;
       int left =0;
       int right;
       for(int i=0, j=0; i < s.length(); i++) {
    	   char currentChar = s.charAt(i);
    	   if(cache.containsKey(currentChar)) {
    		   newLeft = cache.get(currentChar)+1;
    	   }
    		   
    	   ans = Math.max(ans, i-left+1);
    	   left = newLeft;
    	   cache.put(currentChar, i+1);
       }
       return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("MAx = "+lengthOfLongestSubstring("findlongeststr"));

	}

}
