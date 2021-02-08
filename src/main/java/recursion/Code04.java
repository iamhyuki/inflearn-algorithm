package recursion;

public class Code04 {
	
	public static void main(String[] args) {
		System.out.println(findMazePath(0, 0));
	}

	private static int N=8;
	private static int [][] maze = {
		//입구
			{0, 0, 0, 0, 0, 0, 0, 1},
			{0, 1, 1, 0, 1, 1, 0, 1},
			{0, 0, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 0, 1, 1, 0, 0},
			{0, 1, 1, 1, 0, 0, 1, 1},
			{0, 1, 0, 0, 0, 1, 0, 1},
			{0, 0, 0, 1, 0, 0, 0, 1},
			{0, 1, 1, 1, 0, 1, 0, 0} // 출구
	};
	
	/* PATH_COLOR : visited이며 아직 출구로 가는 경로가 될 가능성이 있는 cell
	 * BLOCKED_COLOR : visited이며 출구까지의 경로상에 있지 않음이 밝혀진 cell */
	private static final int PATHWAY_COLOR = 0; // white
	private static final int WALL_COLOR = 1;	// blue
	private static final int BLOCKED_COLOR = 2; // red
	private static final int PATH_COLOR =3;		// green

	public static boolean findMazePath(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N) {		// <- 미로의 유효한 범위가 아닐 경우 : false
			return false;
		} else if (maze[x][y] != PATHWAY_COLOR) {		// <- 안가본 경로가 아닐 경우 : false
			return false;
		} else if (x == N - 1 && y == N - 1) {			// <- 출구일 경우 : true
			maze[x][y] = PATH_COLOR;
			return true;
		} else {
			maze[x][y] = PATH_COLOR;					
			if (findMazePath(x - 1, y) || findMazePath(x, y + 1) || findMazePath(x + 1, y) || findMazePath(x, y - 1)) {
				return true;
			}
			maze[x][y] = BLOCKED_COLOR; // Dead end
			return false;
		}
	}

}
