package com.algorithms.dp;

public class DecodeString {
	public static int min_ways(String s) {
		if(s.length() == 0) return 0;
		if(s.length() == 1) return 1;
		if(s.length() == 2 && Integer.parseInt(s) > 26) return 0;
		if(s.length() == 2 && Integer.parseInt(s) <= 26) return 2;
		return  min_ways(s.substring(1)) + min_ways(s.substring(2)) ;
	}
	
	public static void main(String args[]) {
		System.out.println(min_ways("419"));
	}
}
