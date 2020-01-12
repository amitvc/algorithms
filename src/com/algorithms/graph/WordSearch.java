package com.algorithms.graph;

class WordSearch {
    public static boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];

        for (int row=0; row < board.length; row++) {
            for(int col=0; col < board[row].length; col++) {
                visited[row][col] = false;
            }
        }

        int idx = 0;
        for (int row=0; row < board.length; row++) {
            for(int col=0; col < board[row].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (dfs( word,"", board, visited, row, col)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(String word,
                              String current,
                              char[][] board,
                              boolean[][] visited,
                              int row, int col) {

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] == true ||
        current.length() > word.length()) {
            return false;
        }

        visited[row][col] = true;
        String t = current + board[row][col];
            if(t.equals(word)){
                return true;
            }

        boolean b1 = dfs( word, current + board[row][col], board, visited, row+1, col);
        boolean b2 = dfs( word, current + board[row][col], board, visited, row-1, col);
        boolean b3 = dfs( word, current + board[row][col], board, visited, row, col+1);
        boolean b4 = dfs( word, current + board[row][col], board, visited, row, col-1);
        if ( b1 || b2 || b3 || b4 ) {
            return true;
        }
        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        char board[][] = {
        {
            'A', 'B', 'C', 'E'
        },
        {
            'S', 'F', 'C', 'S'
        },
        {
            'A', 'D', 'E', 'E'
        }
    };

        System.out.println("Word " + exist(board, "ABCCED"));
    }
}