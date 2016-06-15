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

	public static void permute(String a, int l, int r) {
		int i;
		if (l == r) {
			System.out.println("\n " + a);
		} else {
			for (i = l; i <= r; i++) {
				char temp[] = a.toCharArray();
				char t = temp[l];
				temp[l] = temp[i];
				temp[i] = t;
				a = new String(temp);
				permute(a, l + 1, r);
				//swap((a + l), (a + i)); // backtrack
				temp = a.toCharArray();
				t = temp[l];
				temp[l] = temp[i];
				temp[i] = t;
				a = new String(temp);
			}
		}
	}

	public static void main(String[] args) {
		String s = "abcdefghijkl";
		long st = System.currentTimeMillis();
		ListPermutation.recPermute("", s);
		System.out.println("Finished after "+ (System.currentTimeMillis() - st) + " ms");
		//String t = "abcdefghij";
		//permute(t,0,t.length()-1);
	}

}
