package hackerrank;

public class Amazon {

	static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates,
			int[] lockerYCoordinates) {
		int lockerDistance[][] = new int[cityWidth][cityLength];
		// lockerXCordinate and lockerYCordinate should have same lenght;
		if (lockerXCoordinates.length != lockerYCoordinates.length) {
			// Log and error- Typically logger used here.
			System.out.println(
					"The x and y cordinates of lockers provided  are incomplete. Location should have both X and Y cordinate in order to find right distance.");
			return null;
		}

		for (int i = 0; i < lockerXCoordinates.length; i++) {
			if (lockerXCoordinates[i] > 0) {
				lockerXCoordinates[i] = lockerXCoordinates[i] - 1;
			}

			if (lockerYCoordinates[i] > 0) {
				lockerYCoordinates[i] = lockerYCoordinates[i] - 1;
			}
		}

		for (int i = 0; i < cityWidth; i++) {
			for (int j = 0; j < cityLength; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < lockerXCoordinates.length; k++) {
					min = min < Math.abs(lockerYCoordinates[k] - i) + Math.abs(lockerXCoordinates[k] - j)
							? min : Math.abs(lockerYCoordinates[k] - i) + Math.abs(lockerXCoordinates[k] - j) ;
				}
				lockerDistance[i][j] = min;
				System.out.print(lockerDistance[i][j]);
			}
			System.out.println("\n");
		}
		return lockerDistance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int X[] = { 2,2, 4 };
		int Y[] = {2, 3, 7 };
		getLockerDistanceGrid(5, 7, X, Y);
	}

}
