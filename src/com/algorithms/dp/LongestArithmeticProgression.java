package com.algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestArithmeticProgression {

	
	public static int solve(final List<Integer> A) {
        if(A.size() <= 2)
        return A.size();
        
        //dp.get(i).get(j) denotes longest AP ending at i with common difference j
        
        List<Map<Integer, Integer>> dp = new ArrayList<>();
        Map<Integer, Integer> m;
        int ans = 1, diff;
        for(int i = 0; i < A.size(); i++) {
            dp.add(new HashMap<>());
            m = dp.get(i);
            for(int j = 0; j < i; j++) {
                diff = A.get(i) - A.get(j);
                if(dp.get(j).get(diff) == null)
                m.put(diff, 2);
                else
                m.put(diff, dp.get(j).get(diff) + 1);
                if(m.get(diff) > ans)
                ans = m.get(diff);
            }
        }
        
        return ans;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 7, 10, 15, 27, 29};
		List<Integer> l =  new ArrayList<>();
		l.add(1);
		l.add(7);
		l.add(10);
		l.add(15);
		l.add(27);
		l.add(29);
		solve(l);
		
	}

}
