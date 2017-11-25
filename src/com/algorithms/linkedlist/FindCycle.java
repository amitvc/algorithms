package com.algorithms.linkedlist;

public class FindCycle {

	static class ListNode {
		public int val;

		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode detectCycle(ListNode a) {
		if (a == null) {
			return a;
		}

		ListNode slowPtr = a;
		ListNode fastPtr = a;
		boolean isCycle = false;
		while (slowPtr != null || fastPtr != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next == null ? null : fastPtr.next.next;
			if (slowPtr == null || fastPtr == null) {
				return null;
			}
			if (slowPtr.val == fastPtr.val) {
				isCycle = true;
				break;
			}
		}
		
		if(!isCycle) return null;
        ListNode first = a;
        while( first.val !=  fastPtr.val) {
            first = first.next;
            fastPtr = fastPtr.next;
        }

		return first;
	}
	
	public static ListNode deleteDuplicates(ListNode a) {
		ListNode current = a;
		if(a == null) return a;
		
		while(current != null) {
			ListNode lastPtr = current;
			ListNode nextPtr = current.next;
			while(nextPtr != null && nextPtr.val == lastPtr.val) {
				nextPtr = nextPtr.next;
			}
			current.next = nextPtr;
			current = nextPtr;
		}
		
		return a;
	}
	
	public static void main(String args[]) {
		ListNode n1 = new ListNode(1);
		ListNode n11 = new ListNode(1);

		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n3;
		ListNode s = detectCycle(n1);
		n1.next = n11;
		n11.next = n2;
		n2.next = null;
		ListNode nnn = deleteDuplicates(n1);
		
	}
}
