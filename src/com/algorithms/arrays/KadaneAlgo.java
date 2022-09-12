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
			/**
			 * Only add to sumsofar if and only if the curr value + sumsofar > 0.
			 */
			if (sumSoFar + curr > 0) {
				sumSoFar += curr;
			} else {
				// If current value + sumsofar < 0 then restart
				sumSoFar = 0;
			}
			// best answer is max (current ans, sumsofar)
			ans = Math.max(ans, sumSoFar);
		}
		return ans;

	}

	public static void main(String[] args) {
		int a[] = { 423, -9, 10, -1, -2, -1, -3, -3 };
		System.out.println(KadaneAlgo.kadane(a));
	}

}
