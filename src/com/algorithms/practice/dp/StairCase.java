package com.algorithms.practice.dp;

/**
 * Problem Statement -
 * No of ways you can climb 'N' stairs. The only way you can climb stairs is 
 * 1 Step or 2 Steps at a time.
 * E.g - Stairs(2) - {1,1} + {2}
 *       Stairs(3) - {1,2} + {1,1,1}+{2,1}
 *       Stairs(1) - {1}
 *       
 *       So the intuition for solving this problem is 
 *       If I am on the N'th step I would have reached this step either from N-1 step or N-2th step.
 *       This gives a nice recurrence relationship that we can formalize into an algorithm
 *       
 *       Stairs(N) = Stairs(N-1) + Stairs(N-2);
 * @author achavan
 *
 */
public class StairCase {

	
	public static int stairClimb(int N) {
		if(N == 0) {
			return 1;
		}
		
		if(N <   0) return 0;
		
		return stairClimb(N-1) + stairClimb(N-2);
	}
	
	
	public static int stairsClimbBU(int N) {
		int dp[] = new int[N+1];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i < dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[N]; 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stairClimb(45));
		System.out.println(stairsClimbBU(45));

	}

}
