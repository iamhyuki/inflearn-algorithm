package recursion;

public class Code03 {

	public static void main(String[] args) {
		int[] data = { 1, 3, 5, 9, 7 };

		System.out.println(search(data, 5, 7));
		System.out.println(search2(data, 0, 4, 7));
		System.out.println(search3(data, 0, 4, 7));
		System.out.println(search4(data, 0, 4, 9));
		System.out.println(findMax(data, 0, 4));
		System.out.println(findMax2(data, 0, 2));
		
		String[] item = { "1", "3", "5", "7", "9" };
		System.out.println(binarySearch(item, "1", 0, 4));
	}

	// 순차 탐색(암시적 매개변수)
	// * 이 함수의 미션은 data[0]에서 data[n-1] 사이에서 target을 검색하는 것이다. 하지만 검색 구간의 시작 인덱스 0은
	// 보통 생략한다. 즉 암시적 매개변수이다.
	public static int search(int[] data, int n, int target) {
		for (int i = 0; i < n; i++) {
			if (data[i] == target)
				return i;
		}
		return -1;
	}

	// 순차 탐색(명시적 매개변수)
	// * 이 함수의 미션은 data[begin]에서 data[end] 사이에서 target을 검색하다. 즉, 검색 구간의 시작점을 명시적으로 지정한다.
	// (이 함수를 search(data, 0, n-1, target)으로 호출한다면 반복문으로 이루어진 함수와 동일한 일을 하게 된다.
	public static int search2(int[] data, int begin, int end, int target) {
		if (begin > end)
			return -1;
		else if (target == data[begin])
			return begin;
		else
			return search2(data, begin + 1, end, target);
	}
	
	// 순차 탐색(뒤에서부터 탐색)
	public static int search3(int[] data, int begin, int end, int target) {
		if (begin > end)
			return -1;
		else if (target == data[end])
			return end;
		else
			return search3(data, begin, end - 1, target);
	}
	
	// 순차 탐색(중간->앞 / 중간->뒤)
	public static int search4(int[] data, int begin, int end, int target) {
		if (begin > end) {
			return -1;
		} else {
			int middle = (begin + end) / 2;
			if (data[middle] == target)
				return middle;
			int index = search4(data, begin, middle - 1, target);
			if (index != -1)
				return index;
			else
				return search4(data, middle + 1, end, target);
		}
	}

	// 최대값 찾기
	// * 이 함수의 미션은 data[begin]에서 data[end] 사이에서 최대값을 찾아 반환한다. begin<=end라고 가정한다.
	public static int findMax(int[] data, int begin, int end) {
		if (begin == end) {
			return data[begin];
		}
		else {
			return Math.max(data[begin], findMax(data, begin + 1, end));
		}
	}
	
	// 최대값 찾기(다른버전)
	public static int findMax2(int[] data, int begin, int end) {
		if (begin == end)
			return data[begin];
		else {
			int middle = (begin + end) / 2;
			int max1 = findMax(data, begin, middle);
			int max2 = findMax(data, middle + 1, end);
			return Math.max(max1, max2);
		}
	}
	
	// 이진탐색
	// * items[begin]에서 items[end] 사이에서 target을 검색한다.
	public static int binarySearch(String[] items, String target, int begin, int end) {
		if (begin > end)
			return -1;
		else {
			int middle = (begin + end) / 2;
			int compResult = target.compareTo(items[middle]);
			if (compResult == 0)
				return middle;
			else if (compResult < 0)
				return binarySearch(items, target, begin, middle - 1);
			else
				return binarySearch(items, target, middle + 1, end);
		}
	}
}
