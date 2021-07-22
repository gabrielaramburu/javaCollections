package sorting.quicksort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuicksortVersion1 {

	public static void main(String[] args) {
		QuicksortVersion1 qs = new QuicksortVersion1();
		int[] input = {3, 5,6 ,2 ,1 ,9 ,0, 8,7,4};
		System.out.println(Arrays.toString(qs.quickSort(input)));
	}

	/**
	 * Very awkward implementation
	 * 
	 * This version has two problems:
	 * 	1) always execute in order O(n2)
	 * 	2) use much more memory O(n2) also
	 * 
	 */
	public int[] quickSort(int[] array) {
		List<Integer> input = Arrays.stream(array).boxed().collect(Collectors.toList());
		input = quickSort(input);
		return input.stream().mapToInt(v->v).toArray();
	}
	
	private List<Integer> quickSort(List<Integer> array) {
		if (array.size() == 0) return new ArrayList<Integer>();
		
		int pivot = array.get(0);
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		
		for (int i=1; i < array.size(); i++) {
			if (array.get(i) <= pivot) left.add(array.get(i));
			else right.add(array.get(i));
		}
		
		left = quickSort(left);
		right = quickSort(right);

		List<Integer> result = new ArrayList<Integer>();
		result.addAll(left);
		result.add(pivot);
		result.addAll(right);
		
		return result;
	}
}
