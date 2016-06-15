package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	public static int digitsToChange(String value) {
		int digitToChangeCount = 0;
		for(int i=0, j = value.length() -1; i < j; i++, j--) {
			if(value.charAt(i) != value.charAt(j)) {
				digitToChangeCount++;
			}
		}
		
		return digitToChangeCount;
	}
	
	public static void calculatePalindrome(String s, int k) {
		int size = s.length();
		if(k == s.length()) {
			String answer = s.replaceAll("[0-9]", "9");
			System.out.println(answer);
		} else {
			int digitsToChange = digitsToChange(s);
			if(digitsToChange > k) {
				System.out.println("-1");
			} else if(digitsToChange ==0) {
				System.out.println(s);
			} else if(k == digitsToChange) {
				// This is simple case. 	
				StringBuilder sb = new StringBuilder();
				sb.append(s);
				for(int i=0, j = s.length() -1; i < j; i++, j--) {
					if(s.charAt(i) != s.charAt(j)) {
						int indexToBeReplaced = i;
						if(s.charAt(j) < s.charAt(i)) {
							indexToBeReplaced = j;
						}
						  
						sb.replace(indexToBeReplaced, indexToBeReplaced+1 , s.charAt(i) > s.charAt(j) ? ""+s.charAt(i) : ""+s.charAt(j));
					} 
				}
				System.out.println(sb.toString());
			} else if( k > digitsToChange) {
				int changeBothOptionCount = k % digitsToChange;
				StringBuilder sb = new StringBuilder();
				sb.append(s);
				for(int i=0, j = s.length() -1; i < j; i++, j--) {
					if(s.charAt(i) != s.charAt(j) && changeBothOptionCount > 0) {
						String replacementChar = "" +9;//s.charAt(i) > s.charAt(j) ? ""+s.charAt(i) : ""+s.charAt(j);	
						sb.replace(i, i+1 , replacementChar);
						sb.replace(j, j+1 , replacementChar);
						changeBothOptionCount--;
					} else if(s.charAt(i) != s.charAt(j)) {
						int indexToBeReplaced = i;
						if(s.charAt(j) < s.charAt(i)) {
							indexToBeReplaced = j;
						}
						sb.replace(indexToBeReplaced, indexToBeReplaced+1 , s.charAt(i) > s.charAt(j) ? ""+s.charAt(i) : ""+s.charAt(j));
					}
				}
				System.out.println(sb.toString());
			}
			
		}
	}
	
	

    public static void main(String[] args) {
    	
    	Scanner in = new Scanner(System.in);
    	int numberLength = in.nextInt();
    	int k = in.nextInt();
    	String value = in.nextLine();
    	value = in.next();
    	value = value.trim();
    	calculatePalindrome(value, k);
    }
}