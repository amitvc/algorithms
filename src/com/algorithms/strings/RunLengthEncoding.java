package com.algorithms.strings;

public class RunLengthEncoding {

	public static String rle(final String input) {
		StringBuilder sb = new StringBuilder();
		
		char p = input.charAt(0);
		int count = 0;
		
		for(int i=0;i < input.length(); i++) {
			char currentChar = input.charAt(i);
			if(currentChar != p) {
				sb.append(p);
				sb.append(count);
				count = 1;
				p = currentChar;
			} else {
				count++;
			}
		}
		sb.append(p);
		sb.append(count);
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		System.out.println(rle("abzzzzbc"));
	}

}
