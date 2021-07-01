package recursion.boggle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class SolutionTest {

	final private char[][] board = 
		{ 		{ 'E', 'A', 'R', 'A' }, 
				{ 'N', 'L', 'E', 'C' }, 
				{ 'I', 'A', 'I', 'S' },
				{ 'B', 'Y', 'O', 'R' } };
	
	final char[][] board2 = { 
			{'L','H','A','R','R','G','A'},
			{'H','O','E','A','Y','C','L'},
			{'C','A','B','D','T','E','U'},
			{'C','N','A','Y','O','D','A'},
			{'R','O','K','T','L','I','R'},
			{'P','N','I','A','P','T','V'},
			{'G','M','S','E','M','R','S'}
	};
	
	final char[][] board3 = { 
		{'L','F','E','S','O','I','E','Y','Y','A','X','H','N','N','H','Z','F'},
		{'K','B','R','D','Y','G','B','Z','X','N','K','G','K','A','E','Q','V'},
		{'G','P','F','T','Z','Y','E','G','N','U','W','W','G','Q','X','Y','S'},
		{'T','Z','A','C','T','M','P','A','O','Z','N','O','C','C','J','Z','N'},
		{'Q','J','U','V','D','L','L','T','U','R','K','H','U','R','D','O','F'},
		{'Q','T','P','I','E','R','X','Q','Y','M','Z','N','H','Z','N','L','N'},
		{'X','C','H','Z','B','M','A','Z','L','U','R','E','F','W','Z','F','N'},
		{'D','O','Y','G','I','F','Q','K','P','K','X','F','I','H','C','Z','S'},
		{'C','Y','L','O','I','G','A','H','Z','M','G','P','U','D','P','Z','G'},
		{'J','X','X','F','A','Y','V','B','G','J','G','R','B','Y','Z','Y','Y'},
		{'Y','P','D','P','W','F','X','Z','I','G','N','G','Q','L','X','S','Q'},
		{'B','Y','O','R','Q','Z','C','N','X','B','Y','E','Z','X','D','J','V'},
		{'F','J','W','H','C','Y','K','T','O','D','J','F','Q','J','Z','X','V'},
		{'O','U','U','O','L','I','B','G','S','P','X','M','A','W','J','V','N'},
		{'Y','M','L','D','U','N','Y','X','A','Z','G','I','S','V','P','O','V'},
		{'Q','F','V','X','C','L','W','H','L','O','L','R','R','T','S','Q','Z'},
		{'B','A','T','O','C','S','T','Z','D','D','Q','Z','A','X','I','D','T'}
	};

	

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
	
	
	@Test
	public void complexText() {
		assertEquals(true, new Boggle(board2, "IKTLOTDAEULCYRGA").check());
	}
	
	@Test
	public void complexTextWithBigMatrix() {
		assertEquals(true, new Boggle(board3, "TLNBYQFVAF").check());
	}

	@Test
	private void celdsNeighbordsTest() {
		Boggle boogle = new Boggle(board, " ");
		System.out.println(boogle.new Celd(1, 1).findNeighborCelds());
		System.out.println(boogle.new Celd(0, 0).findNeighborCelds());
		System.out.println(boogle.new Celd(2, 2).findNeighborCelds());
	}
	
}
