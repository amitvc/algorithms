package com.algorithms.arrays;

public class RunLengthEncoding {
	
	
	public static int compress1(char chars[]) {
		int currentIndex =0;
		StringBuilder sb = new StringBuilder();
		while(currentIndex <= chars.length-1) {
			char c = chars[currentIndex];
			sb.append(c);
			int charCount = 1;
			int nextPtr;
			for(nextPtr = currentIndex+1; (nextPtr < chars.length && c == chars[nextPtr] ); nextPtr++) {
				charCount++;
			}
			currentIndex = nextPtr;
			if(charCount > 1) {
				sb.append(charCount);
			}
		}
		System.out.println(sb.toString());
		return sb.length();
	}
	
	public static int compress(char chars[]) {
		StringBuilder sb = new StringBuilder();
		char prevChar =  chars[0];
		int charCount = 0;
		sb.append(chars[0]);
		for(char c : chars) {
			if(c != prevChar) {
				if(charCount > 1) {
					sb.append(charCount);
				}
				prevChar = c;
				sb.append(c);
				charCount = 1;
			} else {
				charCount++;
			}
		}
		//This is for the last character.
		if(charCount > 1) {
			sb.append(charCount);
		}
		System.out.println(sb.toString());
		return sb.length();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunLengthEncoding.compress1("aabccaaa".toCharArray());
		RunLengthEncoding.compress1("abcca".toCharArray());
	}
}
