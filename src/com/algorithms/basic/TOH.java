package com.algorithms.basic;


public class TOH {

	public void moveDisks(int n, String start, String dest, String helper) {
		  if (n == 1) {
		 
		   // When n==1, it means we are left with only one disk, so directly move it from source to destination.
		   System.out.println(start + " -> " + dest  + " n = "+n); 
		 
		  } else {
		 
		   // Move (n-1 disk) from Source Peg to Auxiliary Pe
		   moveDisks(n - 1, start, helper, dest);
		 
		   //Move last nth disk to Destination Peg.
		   System.out.println(start + " -> " + dest + " n = "+n);  

		   //Move (n-1 disk) from Auxiliary Peg to Destination Peg.
		   moveDisks(n - 1, helper, dest, start); 
		  }
		  
		 }

    public static void main(String[] args) {
    	TOH towersOfHanoi = new TOH();  
    	 towersOfHanoi.moveDisks(5, "SRC", "DST", "AUX");
    }


}
