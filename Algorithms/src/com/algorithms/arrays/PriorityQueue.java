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
public class PriorityQueue<T extends Comparable<T>> {
	
	private T[] queue;
	int count = 1;
	
	public PriorityQueue(Class<T> type,int size) {
		queue = (T[]) Array.newInstance(type, size);
	}
	
	
	public T max() {
		return queue[1];
	}
	
	public void add(T val) {
		queue[count] = val;
		int index = count;
		while(!isHeap(index)) {
			T temp = queue[index/2];
			queue[index/2] = val;
			queue[index] = temp;
			index = index /2;
		}
		count++;
	}
	
	public void removeMax() {
		if(count == 1) {
			queue[1] = null;
			return;
		}
		
		queue[1] = queue[count -1];
		queue[count -1] = null;
		count--;
		int index = 1;
	
		while((index*2 < count) && (queue[index].compareTo(queue[index*2]) < 0 || queue[index].compareTo(queue[index*2+1]) < 0)) {
			
			if(queue[index*2] != null && queue[index*2+1] != null) {
				int swapIndex = queue[index*2].compareTo(queue[index*2+1]) > 0 ? index*2 : (index*2)+1;
				T temp = queue[index];
				queue[index] = queue[swapIndex];
				queue[swapIndex] = temp;
				index = swapIndex;
			}
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
	

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		int size = 10000;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Integer.class, size);
		for(int i=0; i < size-2; i++) {
			int val = ThreadLocalRandom.current().nextInt(1,100000);
			pq.add(val);
			list.add(val);
		}
		
		Collections.sort(list);
		System.out.println(pq.max());
		if(pq.max().equals(list.get(list.size()-1))) {
			System.out.println("Priority queue works correctly");
		} else {
			System.out.println("Problem with PQ");
		}
		
		pq.removeMax();
		System.out.println(pq);
		pq.removeMax();
		System.out.println(pq);
	}

}
