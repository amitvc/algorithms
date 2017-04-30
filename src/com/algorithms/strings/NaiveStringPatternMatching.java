package com.algorithms.strings;

public class NaiveStringPatternMatching {

	public static boolean brute_force(String text, String pattern) 
	{
	  // let n be the size of the text and m the size of the
	  // pattern

		int n = text.length();
		int m = pattern.length();
		int j=0;
	  for(int i = 0; i < n; i++) {
	    for(j = 0; j < m && i + j < n; j++) {
	    	 if(text.charAt(i+j) != pattern.charAt(j)) break;
	    }
	      // mismatch found, break the inner loop
	    if(j == m) {
	    	// match found
	    	return true;
	    }
	  }
	  return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(brute_force("amitchavan", "amit"));

	}

}
