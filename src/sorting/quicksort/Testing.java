package sorting.quicksort;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class Testing {
	//NOTE: if the array is already sorted the v1 and v2 implementations throws
	//a StackOverflow exception when the arrays is around 10_000 length
	private static final int TEST_SIZE = 5000;
	
	@Test
	void testPerformance() {
		int[] arr1 = new int[TEST_SIZE];
		for (int i=0; i<arr1.length;i++) arr1[i] = new Random().nextInt(TEST_SIZE);
			
		System.out.println("Start sorting...");
		long ini = System.currentTimeMillis();
		Arrays.sort(arr1);
		System.out.println("Execution time Java impletentation = " + (System.currentTimeMillis() - ini));
	
		int[] arr2 = new int[TEST_SIZE];
		for (int i=0; i<arr2.length;i++) arr2[i] = new Random().nextInt(TEST_SIZE);
		ini = System.currentTimeMillis();
		new QuicksortVersion1().quickSort(arr2);
		System.out.println("Execution time v1 = " + (System.currentTimeMillis() - ini));
		
		int[] arr3 = new int[TEST_SIZE];
		for (int i=0; i<arr3.length;i++) arr3[i] = new Random().nextInt(TEST_SIZE);
		ini = System.currentTimeMillis();
		new QuicksortVersion2().quickSort(arr3);
		System.out.println("Execution time v2 = " + (System.currentTimeMillis() - ini));
	}	
		
	@Test
	void testAlreadySortedArrays() {
		int[] arr1 = new int[TEST_SIZE];
		for (int i=0; i<arr1.length;i++) arr1[i] = i;
			
		System.out.println("Start sorting...");
		long ini = System.currentTimeMillis();
		Arrays.sort(arr1);
		System.out.println("Execution time Java impletentation = " + (System.currentTimeMillis() - ini));
	
		int[] arr2 = new int[TEST_SIZE];
		for (int i=0; i<arr2.length;i++) arr2[i] = i;
		ini = System.currentTimeMillis();
		//new QuicksortVersion1().quickSort(arr2);
		System.out.println("Execution time v1 = " + (System.currentTimeMillis() - ini));
		
		int[] arr3 = new int[TEST_SIZE];
		for (int i=0; i<arr3.length;i++) arr3[i] = i;
		ini = System.currentTimeMillis();
		new QuicksortVersion2().quickSort(arr3);
		System.out.println("Execution time v2 = " + (System.currentTimeMillis() - ini));
	}	
}
