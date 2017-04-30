package com.algorithms.arrays;

public class KadaneAlgo {

	/**
	 * 
	 * @param a
	 * @return
	 */
	public static int kadane(int a[]) {

		int ans = 0;
		int sumSoFar = 0;
		for (int curr : a) {
			if(sumSoFar + curr > 0)  {
				sumSoFar += curr;
			} else {
				sumSoFar = 0;
			}
			ans = Math.max(ans,sumSoFar);
		}
		return ans;

	}

	public static void main(String[] args) {
		 int a[] = {10, -9, 42, -1, -2, -1, -3, -3};
		System.out.println(KadaneAlgo.kadane(a));
	}

}
