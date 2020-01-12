
public class MinDistance {

	
	public static int minDistance( int arr[][], int rows, int cols, int destX, int destY) {
		
		boolean visited[][] = new boolean[rows][cols];
		visited[0][0] = true;
		int a = minDistanceFrom(arr, rows, cols, 0, 1, destX, destY, visited);
		int b = minDistanceFrom(arr, rows, cols, 1, 0, destX, destY, visited);
		return 1 + Math.min(a,b);
	}
	
	public static int min(int l, int r, int t, int b) {
		int h = Math.min(l, r);
		int v = Math.min(t, b);
		return Math.min(h, v);
	}
	
	public static int minDistanceFrom(int arr[][], int rows, int cols, 
			int currX, int currY, int destX, int destY, boolean visited[][]) {
	
		if(currX >= rows || currX < 0 || currY >= cols || currY < 0) {
			return 9999;
		}
		
		if(visited[currX][currY]) {
			return 9999;
		}
		
		visited[currX][currY] = true;
		if(arr[currX][currY] == 0) {
			return 9999;
		}
		
		if(arr[currX][currY] == 9) {
			return 0;
		}
		int left = minDistanceFrom(arr, rows, cols, currX, currY+1, destX, destY, visited);
		int right = minDistanceFrom(arr, rows, cols, currX, currY-1, destX, destY, visited);
		int top = minDistanceFrom(arr, rows, cols, currX-1, currY, destX, destY, visited);
		int bottom = minDistanceFrom(arr, rows, cols, currX+1, currY, destX, destY, visited);
		System.out.println("X " + currX + " Y "+ currY);
		System.out.println("Left " + left);
		System.out.println("rigt " + right);

		System.out.println("top " + top);
		System.out.println("bottom " + bottom);

		return 1 + min(left, right, top, bottom);
	}
	
	public static int minDistance(int arr[][], int row, int col) {
		if(row < 0 || col < 0) {
			return Integer.MAX_VALUE;
		}
		
		if(row == 0 && col == 0) return arr[row][col];
		return arr[row][col] + Math.min(minDistance(arr, row -1, col), minDistance(arr, row, col-1));
	}
	
	public static void main(String[] args) {
		
		int arr[][] = {
				{1,0,9,1},
				{1,1,1,1},
				{1,0,1,1},
				{1,1,1,0},
				{1,1,1,0}
		};
		
		//System.out.println(minDistance(arr, 5, 4, 0, 2));
		
		int distance[][] = {
				{3,5,1},
				{2,1,2},
				{4,1,8},
				{8,1,2}
		};
		System.out.println(minDistance(distance,3,2));
	}

}
