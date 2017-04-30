package com.algorithms.dp;

public class BinomialCoffecient {

	public static long i = 0;

	public static int binomialC(int n, int m) {
		i++;
		if (m == n || m == 0)
			return 1;
		else
			return binomialC(n - 1, m - 1) + binomialC(n - 1, m);
	}

	public static int binomial_coefficient(int n,int m)
	{
		int bc[][] = new int[11][11];
		for (int i=0; i<=n; i++) bc[i][0] = 1;
		for (int j=0; j<=n; j++) bc[j][j] = 1;
		for (int i=1; i<=n; i++) {
	        for (int j=1; j<i; j++) {
	                bc[i][j] = bc[i-1][j-1] + bc[i-1][j];
	        }
		}
		return bc[n][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(binomialC(100, 6));
		System.out.println(i);
		System.out.println(binomial_coefficient(10,6));
	}

}
