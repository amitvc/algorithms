package com.algorithms.dp;

public class PascalsTriangle {
	public static void printPascal(int n) {
		for (int line = 1; line <= n; line++) {
			int C = 1; // used to represent C(line, i)
			for (int i = 1; i <= line; i++) {
				System.out.printf("%d ", C); // The first value in a line is
												// always 1
				C = C * (line - i) / i;
			}
			System.out.println("\n");
		}
	}

	public static void printPascalArray(int n)
	{
	  int arr[][] = new int[n][n]; // An auxiliary array to store generated pscal triangle values
	 
	  // Iterate through every line and print integer(s) in it
	  for (int line = 0; line < n; line++)
	  {
	    // Every line has number of integers equal to line number
	    for (int i = 0; i <= line; i++)
	    {
	      // First and last values in every row are 1
	      if (line == i || i == 0)
	           arr[line][i] = 1;
	      else // Other values are sum of values just above and left of above
	           arr[line][i] = arr[line-1][i-1] + arr[line-1][i];
	      System.out.printf("%d ", arr[line][i]);
	    }
	    System.out.println("");
	  }
	}

	public static void main(String[] args) {
		printPascalArray(6);
	}

}
