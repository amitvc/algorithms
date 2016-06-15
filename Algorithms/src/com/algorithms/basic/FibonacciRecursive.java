package com.algorithms.basic;

public class FibonacciRecursive {
	public static long fib(int n) {
		if (n <= 1)
			return n;
		else
			return fib(n - 1) + fib(n - 2);
	}
	
	static int FibonacciIterative(int n)
	{
	    if (n == 0) return 0;
	    if (n == 1) return 1;
	        
	    int prevPrev = 0;
	    int prev = 1;
	    int result = 0;
	        
	    for (int i = 2; i <= n; i++)
	    {
	        result = prev + prevPrev;
	        prevPrev = prev;
	        prev = result;
	    }
	    return result;
	}

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		for (int i = 1; i <= N; i++)
			System.out.println(i + ": " + fib(i));
		
		//for(int i=1; i <= N; i++) {
			System.out.println( FibonacciIterative(7));

		//}
	}

}
