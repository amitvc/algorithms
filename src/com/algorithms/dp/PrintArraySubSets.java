package com.algorithms.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * [1,2,3]
 * [1,2]
 * [2,3]
 * [1,3]
 * [1]
 * [2]
 * [3]
 * []
 * 
 * 
 * @author achavan
 *
 */
public class PrintArraySubSets {

	public static void printAllSubSets(int arr[]) {
		printAllSubSets(arr, 0, new Stack<>());
	}
	
	private static void printAllSubSets(int[] arr, int i, Stack<Integer> list) {
		if(i == arr.length) {
			System.out.println("List --------> "+ list.toString());
			return;
		}
		/*printAllSubSets(arr, i+1, list);
		int currentElement = arr[i];
		list.push(currentElement);
		printAllSubSets(arr,i+1, list);
		list.pop();*/

		int current = arr[i];
		list.push(current);
		printAllSubSets(arr,i+1, list);
		list.pop();
		printAllSubSets(arr, i+1, list);
	}
	
	private static void printAllSubSets(char[] arr, int i, Stack<Character> list) {
		if(i == arr.length) {
			System.out.println("List --------> "+ list.toString());
			return;
		}
		printAllSubSets(arr, i+1, list);
		char currentElement = arr[i];
		list.push(currentElement);		
		printAllSubSets(arr,i+1, list);		
		list.pop();
	}
	
	public static void printAllSubSets(char arr[]) {
		printAllSubSets(arr,0, new Stack<>());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3};
		printAllSubSets(arr);
	}

}
