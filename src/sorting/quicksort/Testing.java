package sorting.quicksort;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Testing {
	private static final int TEST_SIZE = 5000;
	static int[] input = new int[TEST_SIZE];
	
	@BeforeAll
	public static void initialize() {
		Arrays.stream(input).forEach(item -> item =  new Random().nextInt(TEST_SIZE));
	}
	@Test
	void testPerformance() {
		long ini = System.currentTimeMillis();
		new QuicksortVersion1().quickSort(input);
		System.out.println("Execution time v1 = " + (System.currentTimeMillis() - ini));
		
		ini = System.currentTimeMillis();
		new QuicksortVersion2().quickSort(input);
		System.out.println("Execution time v2 = " + (System.currentTimeMillis() - ini));
		
		ini = System.currentTimeMillis();
		Arrays.sort(input);
		System.out.println("Execution time Java impletentation = " + (System.currentTimeMillis() - ini));
	}
}
