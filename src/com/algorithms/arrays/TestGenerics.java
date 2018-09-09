package com.algorithms.arrays;


public class TestGenerics {

	
	public static class GenericNumber<T extends Number > {
		public GenericNumber(T t) {
			this.t = t;
		}
		
		public T t;
	
		
		public static <X extends Number> X add(X x1, X x2) {
			Number n = 10;
			Number n2= 20;
			return x1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
