package sorting.mergeshort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		 //int[] arr = {4, 6, 3, 2 ,8 ,7 ,5 ,9 ,0 , 1};
		int[] arr = { 3 };
		System.out.println("Result " + Arrays.toString(ms.mergeSort(arr)));
	}

	public int[] mergeSort(int[] arr) {
		return mergeSort(arr, 0, arr.length - 1);
	}

	private int[] mergeSort(int[] arr, int low, int high) {
		if ((high - low) > 0) { // merge needs at least a two length array

			int mid = low + ((high - low) / 2);
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);

			merge(arr, low, mid, high);
		}

		return arr;
	}

	private void merge(int[] arr, int low, int mid, int high) {
		System.out.println("low " + low + " mid " + mid + " high " + high);
		List<Integer> aux = new ArrayList<Integer>();

		int i = low, j = mid + 1;
		while (i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				aux.add(arr[i++]);
			} else {
				aux.add(arr[j++]);
			}
		}
		// I have rechead the end of one of the arrays
		if (i > mid) {
			// copy to aux the remaining right size elements (if any)
			for (; j < high; j++)
				aux.add(arr[j]);
		} else {
			// copy to aux the remaining left size elements (if any)
			for (; i <= mid; i++)
				aux.add(arr[i]);
		}

		System.out.println("Auxiliary list " + aux.toString());
		updateOriginalArray(arr, aux, low);
	}

	private void updateOriginalArray(int[] arr, List<Integer> aux, int low) {
		for (Integer val : aux) {
			arr[low++] = val;
		}
	}

}
