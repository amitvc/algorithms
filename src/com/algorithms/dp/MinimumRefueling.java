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
	
	
	public static int minRefuelStopss(int target, int startFuel, int[][] stations) {
        int len = stations.length;
        long[] dp = new long[len + 1];
        dp[0] = startFuel;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j > 0 && dp[j - 1] >= stations[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1] + stations[i][1]);
            }
        }
        for (int i = 0; i <= len; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stations[][] = {
				{10,60},
				{20,20},
				{30,10},
				{60,40}
		};
		
		int minRefuel = minRefuelStopss(100, 10, stations);
		System.out.println("Min Refuel " + minRefuel);
		

	}

}
