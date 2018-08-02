package com.algorithms.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MergeSortedLists {

	public static class Node implements Comparable<Node> {
		public final int val, index, list_index;
		public Node(int val, int index, int list_index) {
			this.val = val;
			this.index = index;
			this.list_index = list_index;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.valueOf(this.val).compareTo(Integer.valueOf(o.val));
		}
	}
	
	
	public static List<Integer> mergeSortedList(List<List<Integer>> sortedLists) {
		List<Integer> result = new ArrayList<>();
		PriorityQueue<Node> minPQ = new PriorityQueue<>();
		int list_index  = 0;
		for(List<Integer> list : sortedLists) {
			Node n = new Node(list.get(0), 0, list_index++);
			minPQ.offer(n);
		}
		
		while(!minPQ.isEmpty()) {
			Node node = minPQ.poll();
			result.add(node.val);
			List<Integer> list = sortedLists.get(node.list_index);
			if(list != null && list.size()-1 > node.index) {
				minPQ.offer(new Node(list.get(node.index+1), node.index+1, node.list_index));
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<>();
		int l1[] = {1,5,8,84,91};
		int l2[] = {2,56,78};
		int l3[] = {98,102,115,129};
		int l4[] = {5,6,7,8};
		lists.add(Arrays.stream(l1).boxed().collect(Collectors.toList()));
		lists.add(Arrays.stream(l2).boxed().collect(Collectors.toList()));
		lists.add(Arrays.stream(l3).boxed().collect(Collectors.toList()));
		lists.add(Arrays.stream(l4).boxed().collect(Collectors.toList()));
		mergeSortedList(lists).toString();
	}

}
