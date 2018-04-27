package com.algorithms.recursion;

public class RemoveCharacter {
	
	public static String removeChar(String original, char x) {
		if(original.isEmpty()) {
			return "";
		}
		if(original.charAt(0) != x ) {
			return original.substring(0,1) + removeChar(original.substring(1),x);
		}
		return removeChar(original.substring(1), x);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(removeChar("aex", 'x'));
	}

}
