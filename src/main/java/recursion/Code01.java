package recursion;

public class Code01 {

	public static void main(String[] args) {
//		func();

//		int n = 4;
//		func2(n);

//		int result = func3(4);
//		System.out.println(result);

//		System.out.println(factorial(5));

//		System.out.println(power(4, 3));
		
//		int n = 10;
//		for(int i=1; i<=n; i++) {
//			System.out.println(fibonacci(i));
//		}
		
		System.out.println(gcd(10, 5));
		System.out.println(gcd2(10, 5));
	}

	// 무한루프에 빠지며 StackOverflowError 발생!
	public static void func() {
		System.out.println("Hello");
		func();
	}

	// 무한루프에 빠지지 않게!
	public static void func2(int n) {
		if (n <= 0) { // Base case : 적어도 하나의 recursion에 빠지지 않는 경우가 존재해야 한다.
			return;
		} else {
			System.out.println("Hello");
			func2(n - 1); // Recursive case : recursion을 반복하다보면 결국 base case로 수렴해야 한다.
		}
	}

	// 이 함수의 misson은 0~n까지의 합을 구하는 것이다.
	/*
	 * int result = func(4); return 4 + func(3); return 3 + func(2); return 2 +
	 * func(1); return 1 + func(0); return 0;
	 */
	public static int func3(int n) {
		if (n == 0) {
			return 0; // n=0이라면 합은 0이다.
		} else {
			System.out.println("Hello");
			return n + func3(n - 1); // n이 0보다 크다면 0에서 n까지의 합은 0에서 n-1까지의 합에 n을 더한 것이다.
		}
	}

	// factorial(!) 예제
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	// Xⁿ 예제
	public static double power(double x, int n) {
		if (n == 0) {
			return 1;
		} else {
			return x * power(x, n - 1);
		}
	}

	// fibonacci Number(피보나치 수열) 에제
	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	// 최대공약수 : Euclid Method
	// m>=n인 두 양의 정수 n과 n에 대해서 m이 n의 배수이면 gcd(m,n)=n이고, 그렇지 않으면 gcd(m,n)=gcd(n, m%n)이다.
	public static double gcd(int m, int n) {
		if (m < n) { // swap m and n
			int temp = m;
			m = n;
			n = temp;
		}
		if (m % n == 0) {
			return n;
		} else {
			return gcd(n, m%n);
		}
	}
	
	// 최대공약수 간략버전
	public static double gcd2(int p, int q) {
		if(q==0) {
			return p;
		} else {
			return gcd2(q, p%q);
		}
	}
}
