package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class TestArrays {
	
	public static class Person {
		
	}
	
	public void testInteger(List<Integer> list) {
		List t = new ArrayList<>();
		t.add("121");
		t.add(new Person());
		
		String s = (String)t.get(0);
		String st = (String) t.get(1); // Fail at run time
	}
	
	
	public void testString(List<String> list) {
		//List<String>[] stringLists = new List<String>[1];  // (1)

	}

	public static void print_arrays(Object []objs) {
		objs[0] = "string";
		objs[1] = 10;
	}
	
	public static void print_generics(List<Object> objs) {
		for(Object o : objs) {
			System.out.println(o.toString());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> int_list = new ArrayList<>();
		Integer[] int_arrays = new Integer[2];
	}
}
