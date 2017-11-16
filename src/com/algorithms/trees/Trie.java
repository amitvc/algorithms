package com.algorithms.trees;

public class Trie {

	public TrieNode root; 
	
	public void insert(String s) {
		if(root == null) {
			root = new TrieNode();
		}
		
		TrieNode t = root;
		
		for(int i=0; i< s.length(); i++) {
			char currentChar = s.charAt(i);
			if(!t.containsKey(currentChar)) {
				t.put(currentChar, new TrieNode());
				t = t.get(currentChar);
			} else {
				TrieNode node = t.get(currentChar);
				if(!node.containsKey(currentChar)) {
					node.put(currentChar, new TrieNode());
				}
				t = node.get(currentChar);
			}
		}
		t.setEnd(true);
		
	}
	
	
	
	public static class TrieNode {
		public TrieNode nodes[];
		public boolean end;
		
		public TrieNode () {
			nodes = new TrieNode[26];
		}
		
		public boolean containsKey(char c) {
			return nodes[c -'a'] != null;
		}
		
		public TrieNode get(char c) {
			return nodes[c-'a'];
		}
		
		public void put(char c, TrieNode newNode) {
			nodes[c-'a'] = newNode; 
		}
		
		public boolean isEnd() {
			return end;
		}
		
		public void setEnd(boolean end) {
			this.end = end;
		}		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie t = new Trie();
		t.insert("lee");
	}

}
