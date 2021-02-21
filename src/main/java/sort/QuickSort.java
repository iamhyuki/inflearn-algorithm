package sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 6, 5, 3, 1, 8, 7, 2, 4 };
		System.out.println(Arrays.toString(arr));

		quickSort(arr);
		System.out.println("-------------------------------quickSort");

		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public static void sort(int[] arr, int low, int high) {
		if (low >= high)
			return;

		int mid = partition(arr, low, high);
		sort(arr, low, mid - 1);
		sort(arr, mid, high);
	}

	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[(low + high) / 2];
		while (low <= high) {
			while (arr[low] < pivot)
				low++;
			while (arr[high] > pivot)
				high--;
			if (low <= high) {
				swap(arr, low, high);
				low++;
				high--;
			}
		}
		return low;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}