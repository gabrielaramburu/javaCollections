package recursion.boggle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class SolutionTest {

	final private static char[][] board = 
		{ 		{ 'E', 'A', 'R', 'A' }, 
				{ 'N', 'L', 'E', 'C' }, 
				{ 'I', 'A', 'I', 'S' },
				{ 'B', 'Y', 'O', 'R' } };

	private static String[] toCheck = { "C", "EAR", "EARS", "BAILER", "RSCAREIOYBAILNEA", "CEREAL", "ROBES" };
	private static boolean[] expecteds = { true, true, false, true, true, false, false };

	@Test
	public void sampleTests() {
		for (int i = 0; i < toCheck.length; i++) {
			String message = "toCheck:" + toCheck[i] + ", expected result: " + expecteds[i];
			assertEquals( expecteds[i], new Boggle(deepCopy(board), toCheck[i]).check(), message);
		}
	}

	private char[][] deepCopy(char[][] arr) {
		return Arrays.stream(arr).map(a -> Arrays.copyOf(a, a.length)).toArray(char[][]::new);
	}
}
