package sorting.bubblesort;

import java.util.Arrays;

public class Bubblesort {

	public static void main(String[] args) {
		Bubblesort bubble = new Bubblesort();
		int[] arr = { 4, 6, 3, 5, 8, 2, 1, 0, 9, 7 };
		bubble.bubbleSort(arr);

	}

	public int[] bubbleSort(int[] arr) {
		for (int limit = arr.length; limit >= 0; limit --) {
			System.out.println("limit " + limit);
			for (int i = 0; i < limit - 1; i++) {
				if (arr[i] > arr[i+1]) {
					swap(arr, i);
					System.out.println(Arrays.toString(arr));
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

}
