package com.algorithms.dp;

public class BinomialCoffecient {

	public static int i = 0;
	public static int binomialC(int n, int m) 	{
		i++;
		if (m==n || m==0)
	         return 1;		
		else return binomialC(n-1, m-1) + binomialC(n-1, m);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(binomialC(100, 76));
		System.out.println(i);
	}

}
