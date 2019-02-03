package com.algorithms.dp;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumRefueling {
	
	public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        long d= startFuel;
        int idx=0, res=0;
        while (true){
            while(idx<stations.length && d>=stations[idx][0]){
                pq.add(stations[idx][1]);
                idx++;
            }
            if (d>=target) return res;
            if (pq.isEmpty()) return -1;
            d+=pq.poll();
            res++;
        }
    }
	
	
	public static int minRefuelStopsDp(int target, int startFuel, int[][] s) {
		
        long[] dp = new long[s.length + 1];
        dp[0] = startFuel;
        for (int i = 0; i < s.length; ++i)
            for (int t = i; t >= 0 && dp[t] >= s[i][0]; --t)
                dp[t + 1] = Math.max(dp[t + 1], dp[t] + s[i][1]);
        for (int t = 0; t <= s.length; ++t)
            if (dp[t] >= target) return t;
        return -1;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stations[][] = {
				{10,60},
				{20,20},
				{30,30},
				{60,40}
		};
		
		
		int minRefuel = minRefuelStopsDp(100, 10, stations);
		System.out.println("Min Refuel " + minRefuel);
		
		minRefuel = minRefuelStops(100, 10, stations);
		System.out.println("Min Refuel " + minRefuel);
	}

}
