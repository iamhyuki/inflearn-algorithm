package sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 6, 5, 3, 1, 8, 7, 2, 4 };
		System.out.println(Arrays.toString(arr));
		
		mergeSort(arr);
		System.out.println("---------------------------MergeSort");
		
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int[] arr) {
		sort(arr, 0, arr.length);
	}

	private static void sort(int[] arr, int low, int high) {
		if (high - low < 2) {
			return;
		}

		int mid = (low + high) / 2;
		sort(arr, 0, mid);
		sort(arr, mid, high);
		merge(arr, low, mid, high);
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low];
		int t = 0, l = low, h = mid;

		while (l < mid && h < high) {
			if (arr[l] < arr[h])
				temp[t++] = arr[l++];
			else
				temp[t++] = arr[h++];
		}
		while (l < mid)
			temp[t++] = arr[l++];
		while (h < high)
			temp[t++] = arr[h++];
		for (int i = low; i < high; i++) {
			arr[i] = temp[i - low];
		}

	}

}
