package sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 6, 5, 3, 1, 8, 7, 2, 4 };
		System.out.println(Arrays.toString(arr));

		insertionSort(arr);
		System.out.println("-------------------------------InsertionSort");

		System.out.println(Arrays.toString(arr));
	}

	public static void insertionSort(int[] arr) {
		for (int end = 1; end < arr.length; end++) {
			int toInsert = arr[end];
			int i = end;
			while (i > 0 && arr[i - 1] > toInsert) {
				arr[i] = arr[i - 1];
				i--;
			}
			arr[i] = toInsert;
		}
	}
}
