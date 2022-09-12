package com.algorithms.practice2022.trees;

import java.util.Arrays;
import java.util.List;

public class CCTest {

    public static int countGroups(List<String> related) {
        char[][] grid = prepareInput(related);
        int rows = grid.length;
        int cols = grid[0].length;
        int groupCount = 0;
        boolean groupFound = false;
        for (int ri =0; ri < rows; ri++) {
            groupFound = false;
            for(int ci=0; ci < cols; ci++) {

                if (ri == ci) { //self relation
                    continue;
                }

                if (grid[ri][ci] == '1') {
                    if(isConnected(grid, ri, ci)) {
                        groupFound = true;
                        continue;
                    } else {
                        groupCount++;
                    }
                }
            }

            if (!groupFound) {
                groupCount++;
            }

        }
        if (groupFound == false) groupCount ++;
        return groupCount;
    }

    public static boolean isSafeToVisit(int[][] grid, int row, int col, int x, int y, boolean[][] visited) {
        if ((x >=0 && x < row) && (y >=0 && y < col)
                && grid[x][y] == 1 && !visited[x][y]){
    return true;

        }

        return false;
    }

    private static boolean isConnected(char[][] grid, int x, int y) {
        if (x == 0) {
            return true;
        }
        // Look for the reverse relationship if it has been already established
        return grid[y][x] == '1' ?  true : false;

    }


    private static char [][] prepareInput(List<String> related) {
        if (related.isEmpty()) {
            throw new IllegalArgumentException("Input provided is empty");
        }

        int rows = related.size();
        int cols = related.get(0).length();
        int i=0;
        char [][] grid = new char[rows][cols];
        for (String val : related) {
            char[] relations = val.toCharArray();
            grid[i] = relations;
            i++;
        }
        return grid;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("1100", "1110", "0110", "0001");
        System.out.println(countGroups(input));
    }
}
