package com.algorithms.dp;

public class TOH {

	
	public static void moveTower(int n, String start, String finish, String temp,Integer moves) {
		
		if(n == 1) {
			System.out.println(start + " --> "+ finish);
			return;
		}
		
		// Move n-1 disks to temp using finish as the temporary storage area.
		moveTower(n-1, start, temp, finish,moves);
		System.out.println(start +" --> "+ finish);
		moves = moves+1;
		moveTower(n-1, temp, finish, start, moves);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer moves = new Integer(0);
		moveTower(3, "A", "B", "C",moves);
		System.out.println(moves);
	}	

}
