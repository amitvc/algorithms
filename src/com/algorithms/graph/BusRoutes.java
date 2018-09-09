package com.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {

	public static void main(String[] args) {
		int routes[][] = {
				{1, 2, 7}, {3, 6, 7}
		};
		
		System.out.println(numBusesToDestination(routes, 1, 6));
	}
	
	    public static int numBusesToDestination(int[][] routes, int S, int T) {
	        Map<Integer, List<Integer>> map = new HashMap<>();
	        Set<Integer> visited = new HashSet<>();
	        Queue<Integer> q = new LinkedList<>();
	        int res = 0;
	        if (S == T) return res;
	        for (int i = 0; i < routes.length; i++) {
	            for (int j = 0; j < routes[i].length; j++) {
	                List<Integer> connected = map.getOrDefault(routes[i][j], new ArrayList<>());
	                connected.add(i);
	                map.put(routes[i][j], connected);
	            }
	        }
	        
	        q.offer(S);
	        
	        while (!q.isEmpty()) {
	            int curSize = q.size();
	            res++;
	            while (curSize-- > 0) {
	                int cur = q.poll();
	                List<Integer> connected = map.get(cur);
	                for (int bus : connected) {
	                    if (visited.contains(bus)) continue;
	                    visited.add(bus);
	                    for (int i = 0; i < routes[bus].length; i++) {
	                        if(routes[bus][i] == T) return res;
	                        q.offer(routes[bus][i]);
	                    }
	                }
	            }
	            
	        }
	        return -1;
	        
	    }

}
