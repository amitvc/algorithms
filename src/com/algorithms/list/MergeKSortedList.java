package com.algorithms.list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
	public static class EntryNode {
        public int index;
        public int val;
        public EntryNode(int i, int v) {
        	this.val = v;
        	this.index = i;
        }
        
    }
	
	public static class ListNode {
		
	}
	
	public static void main(String[] args) {
		PriorityQueue<EntryNode> pq = new PriorityQueue<>( new Comparator<EntryNode>() {
			@Override
			public int compare(EntryNode o1, EntryNode o2) {
				return Integer.compare(o1.val, o2.val);
			}
		});
		
		

	}

}
