package com.algorithms.dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

	public static Map<Long, Long> map = new HashMap<>();
	
	public static long memoizedStairs(long n) {
		if(n <=1) {
			return 1;
		} else {
			if(map.containsKey(n)) {
				return map.get(n);
			} else {
				long answer = memoizedStairs(n-1) + memoizedStairs(n-2);
				map.put(n,answer);
				return answer;
			}
		}
	}
	
	
	public static long stairsBottomUp(int n) {
		long stairs[] = new long[n+1];
		stairs[0] = 1;
		stairs[1] = 1;
		
		for(int i=2; i < n+1; i++) {
			stairs[i] = stairs[i-1] + stairs[i-2];
		}
		return stairs[n];
	}
	
	
	
	public static long stairs(long n) {
		if(n <=1) {
			return 1;
		} else {
			return stairs(n-1) + stairs(n-2);
		}
	}
	public static void main(String[] args) {
		int value = 45;
		long start = System.currentTimeMillis();
		System.out.println(stairs(value));
		System.out.println("Time taken recursive algo " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		System.out.println(memoizedStairs(value));
		System.out.println("Time taken recursive algo with memoization " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		System.out.println(stairsBottomUp(value));
		System.out.println("Time taken bottom up algo " + (System.currentTimeMillis() - start));
	}

}
