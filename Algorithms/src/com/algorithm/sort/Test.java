package com.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static ArrayList<ArrayList<Integer>> performOps(List<List<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());
        
            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
}
	
	public static ArrayList<Integer> performsOps(List<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
                B.set(i, A.get(i));
                B.set(i + A.size(), A.get((A.size() - i) % A.size()));
                
        }
        
        //5 10 2 1 5 1 2 10 
        return B;
}

	public static void main(String[] args) {
		
		Integer [] A = {5, 10, 2, 1};

		ArrayList<Integer> B1 = performsOps(Arrays.asList(A));
		for (int i = 0; i < B1.size(); i++) {
		        System.out.print(B1.get(i) + " ");
		}

	}

}
