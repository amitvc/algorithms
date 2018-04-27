package com.algorithms.recursion;

public class CheckAB {
	
	public static boolean checkAB(String input) {
		// Write your code here
		if(input.isEmpty() || input.charAt(0) != 'a') {
			return false;
		} else {
			return checkAB(input.substring(1), ""+input.charAt(0));
		}
	}

	public static boolean checkAB(String input, String previous) {
		System.out.println( input+","+previous);
		if(input.isEmpty() && (previous.equals("a") || previous.equals("bb"))) {
			return true;
		} else {
			if(previous.equals("a")) {
				return checkAB(input.substring(1), input.substring(0,1)) || checkAB(input.substring(2), input.substring(0,2));
			} else if(previous.equals("bb")) {
				return checkAB(input.substring(1), input.substring(0,1));
				
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkAB("abba"));

	}

}
