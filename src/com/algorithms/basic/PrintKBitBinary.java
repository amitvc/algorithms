package com.algorithms.basic;

public class PrintKBitBinary {

	public static void print(int n, char str[]) {
		int size = (int) Math.pow(2, n);
		System.out.println("So many combinations "+ size);
		for(int i=0; i < size; i++) {
			for(int j=0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                	System.out.print(str[j]);
                } else {
                	//System.out.print("0");
                }
			}
			System.out.println("");
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str = {'a','b','c'};
		print(3,str);

	}

}
