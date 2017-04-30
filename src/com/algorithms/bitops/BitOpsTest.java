package com.algorithms.bitops;

public class BitOpsTest {

	
	public static int countBits(int number) {
		int count = 0;
		if(number == 0) return count;
		
		while(number != 0) {
			int val = number & 0x01;
			if(val == 1) count++;
			
			number = number >>> 0x01;
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countBits(255));
	}

}
