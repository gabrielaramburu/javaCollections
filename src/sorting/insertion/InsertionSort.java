package sorting.insertion;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 4, 6, 3, 2, 8, 7, 5, 9, 0, 1 };
		InsertionSort in = new InsertionSort();
		System.out.println("Result " + Arrays.toString(in.insertionSort(arr)));
	}

	private int[] insertionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				swap(arr, i);
				int aux = i;
				while (aux > 0) {
					if (arr[aux] < arr[aux - 1]) {
						swapBefore(arr, aux);
					} else
						break;

					aux--;
				}
			}
		}
		return arr;
	}

	private void swap(int[] arr, int i) {
		int aux = arr[i];
		arr[i] = arr[i + 1];
		arr[i + 1] = aux;
	}

	private void swapBefore(int[] arr, int i) {
		int aux = arr[i];
		arr[i] = arr[i - 1];
		arr[i - 1] = aux;
	}

}
