package recursion;

public class Code02 {

	public static void main(String[] args) {
		System.out.println(length("ace"));
		
		printChars("ace"); System.out.println();
		
		printCharsReverse("ace"); System.out.println();
		
		printInBinary(10); System.out.println();
		
		int[] data = {1, 2, 3, 4, 5};
		System.out.println(sum(5, data));
		
	}

	// 문자열의 길이 계산
	public static int length(String str) {
		if (str.equals("")) {
			return 0;
		} else {
			return 1 + length(str.substring(1));
		}
	}
	
	// 문자열의 프린트
	public static void printChars(String str) {
		if(str.length() == 0) {
			return;
		} else {
			System.out.print(str.charAt(0));
			printChars(str.substring(1));
		}
	}
	
	// 문자열을 뒤집어 프린트
	public static void printCharsReverse(String str) {
		if(str.length()==0) {
			return;
		} else {
			printCharsReverse(str.substring(1));
			System.out.print(str.charAt(0));
		}
	}
	
	// 2진수로 변환하여 출력
	public static void printInBinary(int n) {
		if(n<2) {
			System.out.print(n);
		} else {
			printInBinary(n/2);
			System.out.print(n%2);
		}
	}
	
	// 배열의 합 구하기
	public static int sum(int n, int[] data) {
		if(n<=0) {
			return 0;
		} else {
			return sum(n-1, data) + data[n-1];
		}
	}
	
}
