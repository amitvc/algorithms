package com.algorithms.basic;

public class RecursiveCount {

	String reverseString(String line) {
		if (line.equals(""))
			return "";
		else
			return reverseString(line.substring(1)) + line.charAt(0);
	}
	
	int countSpaces(String s) {
		if(s.length() == 0) {
			return 0;
		} else {
			return (s.charAt(0) == ' ' ? 1 : 0) + countSpaces(s.substring(1));
		}
	}

	public void count(int n) {
		System.out.println("in function count(" + n + ")");
		if (n == 0) {
			System.out.println("Done counting");
		} else {
			System.out.println(n);
			count(n - 1);
			System.out.println("Returning after count(" + (n - 1) + ")");
		}
	}

	public static void main(String[] args) {
		RecursiveCount rc = new RecursiveCount();
		rc.count(4);
		System.out.println(rc.reverseString("Amit Chavan"));
		System.out.println("Spaces " + rc.countSpaces("a s fed g e ddd   df "));
	}

}
