package com.algorithms.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Max priority queue implementation using arrays.
 * Root is the maxixum element in the queue and is at index 1.
 * Children of any node a[i] are in a[i*2] and in a[i*2+1] place in the queue.
 * @author amit
 *
 * @param <T>
 */
public class MyPriorityQueue<T extends Comparable<T>> {
	
	private T[] queue;
	int count = 0;
	
	public MyPriorityQueue(Class<T> type,int size) {
		queue = (T[]) Array.newInstance(type, size);
	}
	
	
	public T max() {
		return queue[1];
	}
	
	private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            swap(k, k/2);
            k = k/2;
        }
    }
	
	private boolean less(int s, int d) {
	    if(queue[s].compareTo(queue[d]) <= 0) {
            return true;
        }
	    return false;
	}
	
	public void add(T val) {
		queue[++count] = val;
		swim(count);
	}
	
	public void removeMax() {
		if(count == 1) {
			queue[1] = null;
			return;
		}
		queue[1] = queue[count];
		queue[count] = null;
		count--;
		sink(1);
	}
	
	public void sink(int k) {
	    while (2*k <= count) {
            int j = 2*k;
            if (j < count && less(j, j+1)) j++;
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
	}
	
	public boolean isHeap(int index) {
		if(queue[index/2] == null) {
			return true;
		}
		if(queue[index].compareTo(queue[index/2]) >= 0) {
			return false;
		}
		return true;
	}
	
	public void swap(int s, int d) {
	    T t = queue[s];
	    queue[s] = queue[d];
	    queue[d] = t;
	}
	
	public void print() {
	    for(T t : queue) {
	        if(t != null) {
	            System.out.print(t + ",");
	        }
	    }
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		int size = 10;
		MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(Integer.class, size);
		for(int i=0; i < size-2; i++) {
			int val = ThreadLocalRandom.current().nextInt(1,1000);
			pq.add(val);
			list.add(val);
		}
		
		Collections.sort(list);
		pq.print();
		System.out.println("\nCurrent Max " +pq.max());
		pq.removeMax();
		pq.print();
        System.out.println("\nCurrent Max " +pq.max());
		pq.removeMax();
		pq.print();
        System.out.println("\nCurrent Max " +pq.max());
        pq.removeMax();
        pq.print();
        System.out.println("\nCurrent Max " +pq.max());
	}
}