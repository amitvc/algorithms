package com.algorithms.basic;

public class ListPermutation {

	public static void recPermute(String soFar, String rest) {
		// System.out.println("sofar "+ soFar + " rest "+rest);
		if (rest.equals("")) {
			System.out.println(soFar);
		} else {
			for (int i = 0; i < rest.length(); i++) {
				String next = soFar + rest.charAt(i);
				String remaining = rest.substring(0, i) + rest.substring(i + 1);
				recPermute(next, remaining);
			}
		}
	}

	public static void main(String[] args) {
		String s = "abc";
		long st = System.currentTimeMillis();
		ListPermutation.recPermute("", s);
		System.out.println("Finished after "+ (System.currentTimeMillis() - st) + " ms");
		//String t = "abcdefghij";
		//permute(t,0,t.length()-1);
	}

}
