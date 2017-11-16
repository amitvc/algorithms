package com.algorithms.backtracking;

public class RatInMaze {
	
	public static boolean helpRatFindPath(int arr[][]) {
		boolean visited[][] = new boolean[arr.length][arr.length];
		if(mazeSolver(arr, visited, 0,0)) {
			System.out.println("Rat found the path out of the maze");
		} else {
			System.out.println("No path");
		}
		printSolution(visited);
		return true;
	}
	
	
	public static boolean isSafe(int maze[][], int x, int y) {
		if(x > maze.length-1 || y > maze.length-1 || maze[x][y] != 1) return false;
		return true;
	}
	
	
	public static void printSolution(boolean sol[][])
    {
        for (int i = 0; i < sol.length; i++)
        {
            for (int j = 0; j < sol.length; j++)
                System.out.print(" " + (sol[i][j] == true ? 1 : 0) +
                                 " ");
            System.out.println();
        }
    }
	
	public static boolean mazeSolver(int maze[][], boolean visited[][], int x, int y) {
		if(x == maze.length-1 && y == maze.length -1) {
			System.out.println("Rat found the path out of the maze");
			return true;
		}
		
		if(isSafe(maze, x, y)) {
			//mark the current location as visited
			visited[x][y] = true;
			// Go right
			if(mazeSolver(maze, visited, x+1, y)) {
				return true;
			}			
			
			// Go down
			if(mazeSolver(maze, visited, x, y+1)) {
				return true;
			}
			
			visited[x][y] = false;
			return false;
			// back track
			
		}
		return false;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maze[][] = {{1, 0, 0, 0},
	            {1, 1, 0, 1},
	            {0, 0, 0, 0},
	            {1, 1, 1, 1}};
	            
	    RatInMaze.helpRatFindPath(maze);

	}

}
