package sorting.quicksort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This version is able to perform a O(nlogn) sorting.
 * As it's well know, this best case will depends on the arrays characteristics.
 *
 */
public class QuicksortVersion2 {
	public static void main(String[] args) {
		QuicksortVersion2 v2 = new  QuicksortVersion2();
		int[] input = {3, 5, 6 ,2 ,1 ,9 ,0, 8,7,4};
		System.out.println(Arrays.toString(v2.quickSort(input)));
	}

	public int[] quickSort(int[] input) {
		List<Integer> result = quickSort(Arrays.stream(input).boxed().collect(Collectors.toList()), 0, input.length);
		return result.stream().mapToInt(v->v).toArray();
	}
	
	private List<Integer> quickSort(List<Integer> input, int low, int high) {
		if (low < high) {
			int j = partition(input, low, high);
			quickSort(input, low, j);
			quickSort(input, j+1, high);
		}
		return input;
	}

	private int partition( List<Integer> input, int low, int high) {
		//System.out.println("entrada " + input.subList(low, high).toString());
		int pivot = input.get(low);
		//System.out.println("pivot " + pivot + " low " + low + " higj " + high);
		int i = low;
		int j = high;
		
		while ( i < j) {
			do {
				i++;
			} while (i < high && input.get(i) <= pivot);
			
			do {
				j--;
				
			} while (j >= low && input.get(j) > pivot );
			
			if (i < j) {
				//swap elements
				Collections.swap(input, i, j);
				//System.out.println("cambio " + input.toString());
			}
		}
		//swap pivot with j
		Collections.swap(input, low, j);

		//System.out.println(" partition index " + j);
		//System.out.println("salida " + input.subList(low, high).toString());
		return j;
	}
}
