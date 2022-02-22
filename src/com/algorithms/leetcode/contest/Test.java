package com.algorithms.leetcode.contest;

public class Test {

	
	 /// 11 10 0
	public static boolean isOneBitCharacter(int[] bits) {
        
        return false;
        
    }
	// 0 1 0 = false
	// 11 = false
	// 00 = true
	// 1000 = true
	// 1, 1, 1, 0 = false
	//1, 0, 0  = true
	public static void main(String[] args) {
		int arr[] = {1,1};
		char chars[] = {'a','a','b','b','c','c'};//,'b','b','b','b','b','b','b','b','b','b','b','b'};
		System.out.println(compress("aaabbaa".toCharArray()));
		
	}
	//abc => abc
	//aabbaacc = > a2b2a2c2
	public static int compress(char[] chars) {
		int length = 0;
		int charCount = 0;
		char ch= ' ';
		String compressed = "";
		String str = new String(chars);
	      int count=1;
	      for (int x = 0; x < str.length(); x++) { 
	         if (ch == str.charAt(x)){
	            count = count + 1;
	         } else {
	            compressed = compressed + ch;
	            if(count != 1){
	               compressed = compressed + count;
	            }
	            ch = str.charAt(x);
	            count = 1;
	         }
	      }
	      compressed = compressed + ch;
	      if(count != 1){
	         compressed = compressed + count;
	      }	
	      compressed = compressed.substring(1);
	      for(int i=0; i < compressed.length(); i++) {
              chars[i] = compressed.charAt(i);
          }
        return compressed.length();
    }

}
