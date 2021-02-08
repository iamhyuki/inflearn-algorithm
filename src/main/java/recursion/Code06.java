package recursion;

public class Code06 {

	public static void main(String[] args) {
		System.out.println(queens(0));
	}

	private static int N = 8;
	private static int[] cols = new int[N + 1];

	private static boolean queens(int level) {
		if (!promising(level))
			return false;
		else if (level == N) {
			for (int i = 1; i <= N; i++)
				System.out.println("(" + i + ", " + cols[i] + ")");
			return true;
		}
		for (int i = 1; i <= N; i++) {
			cols[level + 1] = i;
			if (queens(level + 1))
				return true;
		}
		return false;
	}

	private static boolean promising(int level) {
		for (int i = 1; i < level; i++) {
			if (cols[i] == cols[level])
				return false;
			else if (level - i == Math.abs(cols[level] - cols[i])) // 같은 대각선에 놓였는지 검사!(절댓값 이용)
				return false;
		}
		return true;
	}
}
