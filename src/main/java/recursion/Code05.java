package recursion;

public class Code05 {

	public static void main(String[] args) {
		System.out.println(countCells(5, 3));
	}
	private static int N = 8;
	
	private static int [][] grid = {
			{1, 0, 0, 0, 0, 0, 0, 1},
			{0, 1, 1, 0, 0, 1, 0, 0},
			{1, 1, 0, 0, 1, 0, 1, 0},
			{0, 0, 0, 0, 0, 1, 0, 0},
			{0, 1, 0, 1, 0, 1, 0, 0},
			{0, 1, 0, 1, 0, 1, 0, 0},
			{1, 0, 0, 0, 1, 0, 0, 1},
			{0, 1, 1, 0, 0, 1, 1, 1}
	};

	private static int BACKGROUD_COLOR = 0;
	private static int IMAGE_COLOR = 1;
	private static int ALREADY_COUNTED = 2;

	public static int countCells(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return 0;
		else if (grid[x][y] != IMAGE_COLOR)
			return 0;
		else {
			grid[x][y] = ALREADY_COUNTED;
			return 1 + countCells(x - 1, y + 1) + countCells(x, y + 1)
				+ countCells(x + 1, y + 1) + countCells(x - 1, y)
				+ countCells(x + 1, y) + countCells(x - 1, y - 1)
				+ countCells(x, y - 1) + countCells(x + 1, y - 1);
		}

	}

}
