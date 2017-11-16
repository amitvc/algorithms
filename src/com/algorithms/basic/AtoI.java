package com.algorithms.basic;

public class AtoI {

	
	public static int atoI(String val) {
		int rc = 0;
		
		if(val.length() > 0) {
			for(int i=0 ;i < val.length(); i++) {
				char c = val.charAt(i);
				System.out.println("c = " + (c -'0'));
				rc = (int) (rc + (c-'0') * Math.pow(10, (val.length() - i -1)));
				
			}
		}
		
		return rc;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(atoI("1290"));
	}

}
