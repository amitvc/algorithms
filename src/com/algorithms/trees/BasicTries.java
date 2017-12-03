package com.algorithms.trees;

import com.algorithms.trees.Trie.TrieNode;

public class BasicTries {

	/**
	 * This class represents a node in the trie. A trieNode contains 0 or more other
	 * neighboring TrieNodes. Also has a special property that indicates this node
	 * is also a a complete word.
	 * 
	 * @author achavan
	 *
	 */
	public static class TrieNode {
		private static final int LETTER_COUNT = 26;
		private TrieNode[] neighbors;
		private boolean isCompleteWord;

		public TrieNode() {
			isCompleteWord = false;
			neighbors = new TrieNode[LETTER_COUNT];
		}

		public boolean contains(char c) {
			return neighbors[c - 'a'] != null;
		}

		public void add(char c, TrieNode n) {
			neighbors[c - 'a'] = n;
		}

		public void wordComplete() {
			this.isCompleteWord = true;
		}

		public TrieNode get(char c) {
			return neighbors[c - 'a'];
		}
	}

	private TrieNode root;

	public void insert(String s) {
		if (root == null) {
			root = new TrieNode();
		}

		TrieNode ptr = root;
		for (int i = 0; i < s.length(); i++) {
			if (!ptr.contains(s.charAt(i))) {
				ptr.add(s.charAt(i), new TrieNode());
				ptr = ptr.get(s.charAt(i));
			} else {
				ptr = ptr.get(s.charAt(i));
			}
		}
		ptr.wordComplete();
	}

	public boolean search(String s) {
		TrieNode ptr = root;
		if(ptr !=  null) {
			for(int i=0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(!ptr.contains(c)) {
					ptr = null;
					break;
				} else {
					ptr = ptr.get(c);
				}
			}
		}
		return ptr != null; 
	}

	public static void main(String[] args) {
		BasicTries bt = new BasicTries();
		bt.insert("amit");
		bt.insert("amita");
		bt.insert("tima");
		System.out.println("tim " + bt.search("tim"));
		System.out.println("amit " + bt.search("amit"));

	}

}
