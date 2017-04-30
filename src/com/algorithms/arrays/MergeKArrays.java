package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class MergeKArrays {

	public static class QueueNode implements Comparable<QueueNode> {
		private final int value; // this is actual value.
		private final int arrayIndex; // Which array it belongs  to
		private final int nodeIndex; // index within that array.
		
		public QueueNode(int val, int arrayIndex, int nodeIndex) {
			this.value  = val;
			this.arrayIndex = arrayIndex;
			this.nodeIndex = nodeIndex;
		}
		
		@Override
		public int compareTo(QueueNode o) {
			if(this.value < o.value) return -1;
			if(this.value > o.value) return 1;
			return 0;
		}
		
	}
	
	
	public static void mergeAndPrint(int [][] array) {
		Queue<QueueNode> pq = new PriorityQueue<>(array.length, new Comparator<QueueNode>() {
			@Override
			public int compare(QueueNode o1, QueueNode o2) {
				return o1.value - o2.value;
			}
		});
		
		for(int i=0; i < array.length;i++) {
			pq.offer(new QueueNode(array[i][0], i, 0));
		}
		
		int merged[] = new int[array.length*5];
		
		for(int i=0;i<merged.length;i++) {
			QueueNode qn = pq.poll();
			merged[i] = qn.value;
			int nextNodeIndex = qn.nodeIndex+1;
			if(nextNodeIndex < 5) {
				QueueNode nextNode = new QueueNode(array[qn.arrayIndex][nextNodeIndex], qn.arrayIndex, nextNodeIndex);
				pq.offer(nextNode);
			} 
		}
		
		System.out.println("\n\n-------------------Result of Priority Queue Merge :\n");
		System.out.println(Arrays.toString(merged));
		
	}
	
	
	public static void mergeAndPrint(List<List<Integer>> lists) {
		for(List<Integer> list : lists) {
			Collections.sort(list);
			System.out.println(Arrays.toString(list.toArray()));
		}
		
		int[] indexArray = new int[lists.size()];
		Arrays.fill(indexArray, 0);
		int [] mergedArray = new int[lists.size()*5];
		for(int i=0; i < lists.size()*5; i++) {
			int  minValue = Integer.MAX_VALUE;
			int listIndex = 0;
			for(int j =0; j < indexArray.length; j++) {
				if(indexArray[j] >= indexArray.length) continue;
				int value = lists.get(j).get(indexArray[j]);
				if(value < minValue) {
					minValue = value;
					listIndex = j;
				}
			}
			mergedArray[i] = lists.get(listIndex).get(indexArray[listIndex]);
			indexArray[listIndex] +=1;
		}
		
		System.out.println("\n---------------\n"+Arrays.toString(mergedArray));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> unsortedList = new ArrayList<>();
		int arraysToMerge[][] = new int[5][5];
		for(int i=0; i < 5; i++) {
			List<Integer> list = new ArrayList<>();
			for(int j=0; j < 5; j++) {
				int val = ThreadLocalRandom.current().nextInt(0, 500);
				arraysToMerge[i][j] = val;
				list.add(val);
			}
			Arrays.sort(arraysToMerge[i]);
			unsortedList.add(list);
		}
		
		mergeAndPrint(unsortedList);
		mergeAndPrint(arraysToMerge);

	}

}
