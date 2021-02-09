package recursion;

public class Code07 {

	public static void main(String[] args) {
		powerSet(0);
	}
	
	private static char data[]  = {'a', 'b', 'c', 'd', 'e'};
	private static int n = data.length;
	private static boolean[] include = new boolean[n];												
												// boolean include, int k -> 트리상에서 현재 나의 위치를 표현한다.
	public static void powerSet(int k) {
		if (k == n) { 		// 만약 내 위치가 리프노드라면
			for (int i = 0; i < n; i++)
				if (include[i])
					System.out.print(data[i] + " ");
			System.out.println();
			return;
		}
		include[k] = false; // 왼쪽으로 내려갔다가
		powerSet(k + 1);
		include[k] = true; 	// 오른쪽으로 내려간다.
		powerSet(k + 1);
	}

}
