package com.algorithms.practice2022.trees;

public class SuffixTree {

    private final STNode root;

    public SuffixTree() {
        root = new STNode();
    }

    public void formTree(String input) {
        for (int i=0; i < input.length(); i++) {
            String value = input.substring(i);
            addWord(value);
        }
    }

    public void print() {
        for (int idx=0; idx < 26; idx++) {
            if (root.children[idx] != null) {
                print(root.children[idx], idx,  String.valueOf(Character.toChars('a'+idx)));
            }
        }
    }

    private void print(STNode n, int idx, String current) {
        if (n.getWordEnd()) {
            System.out.print(current);
            System.out.println("\n**********");
        }
        for(int i=0; i <26; i++) {
            if (n.children[i] != null) {
                print(n.children[i], i, current + " " + String.valueOf(Character.toChars('a' + i)));
            }
        }
    }

    private void addWord(String value) {
        STNode current = root;
        for (int i=0; i < value.length(); i++) {
            char c = value.charAt(i);
            int idx = c -'a';
            current = current.getChildAtIndex(idx);
        }
        current.setWordEnd();
    }

    private static class STNode {
        private final STNode children[];
        private boolean wordEnd;

        public STNode() {
            children = new STNode[26];
            wordEnd = false;
        }

        public STNode getChildAtIndex(int i) {
            STNode node = null;
            if (children[i] == null) {
                node = new STNode();
                children[i] = node;
            }
            return children[i];
        }

        public void setWordEnd() {
            wordEnd  = true;
        }

        public boolean getWordEnd() {
            return this.wordEnd;
        }
    }


    public static void main(String[] args) {
        String input = "banana";
        SuffixTree st = new SuffixTree();
        st.formTree(input);
        st.print();
    }
}
