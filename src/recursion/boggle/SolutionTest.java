package recursion.boggle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
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

	
	final char[][] board4 = { 
	{'F','N','T','J','M','S','G','W','S','I','H','C','D','S','Q','J','L'},
	{'E','S','P','J','P','T','B','M','Y','R','L','Y','V','A','M','G','G'},
	{'Y','J','M','X','V','L','U','T','L','L','I','S','Z','R','G','X','P'},
	{'C','P','M','F','J','U','K','V','D','Z','T','D','S','G','U','I','W'},
	{'M','K','Z','X','Z','P','E','R','D','M','R','L','T','V','W','T','Q'},
	{'D','N','B','O','R','N','W','V','B','W','D','O','I','C','A','G','O'},	
	{'R','I','G','D','H','W','G','P','R','N','Q','N','S','A','H','J','A'},
	{'K','K','G','S','Y','H','Q','N','N','S','L','Z','K','V','W','N','P'},
	{'H','M','J','I','M','N','X','V','F','Z','T','E','Y','G','L','K','L'},
	{'U','X','Z','M','W','L','J','T','A','C','K','C','K','U','O','E','P'},
	{'A','F','V','A','L','O','F','Z','Q','L','H','W','I','P','E','M','H'},//10
	{'K','Z','Z','A','M','X','T','U','Z','Z','S','D','N','A','W','L','Y'},
	{'S','U','U','K','L','E','P','V','P','H','X','E','Q','D','J','X','R'},
	{'D','H','R','X','P','S','Q','I','O','K','O','U','X','K','D','J','G'},
	{'I','C','D','O','T','C','V','B','E','Z','V','X','M','B','F','V','I'},
	{'J','G','D','H','E','J','F','J','W','A','Q','T','U','G','S','A','L'},
	{'T','H','U','Q','P','Z','Z','Z','N','X','P','L','A','G','T','S','I'}
	};
	
	final char[][] board5 = { 
			
			{'M','W','A','L','O','P','G','I','M','E','Q','N','I','V','Z','P','N','L'},
			{'E','S','S','N','G','R','Y','Z','G','O','J','D','H','W','B','Q','I','E'},
			{'J','W','K','X','D','Q','R','H','P','Y','E','A','T','K','C','G','K','L'},
			{'W','T','H','M','J','J','T','H','Z','W','T','Z','C','O','W','P','X','I'},
			{'Q','X','F','Z','K','U','G','K','Q','Y','D','H','Y','Q','X','I','O','H'},
			{'A','Z','K','E','R','Y','B','L','K','C','E','E','P','L','R','J','M','F'},
			{'Z','G','J','Z','F','F','K','Z','G','K','D','J','F','R','U','T','L','J'},
			{'A','V','R','U','E','H','I','Z','U','O','F','M','H','P','F','K','M','W'},
			{'L','K','E','T','V','X','U','M','S','R','P','D','L','A','N','G','V','V'},
			{'I','S','U','G','K','A','Z','F','O','H','V','G','Q','P','Y','U','V','Y'},
			{'B','E','T','H','X','S','O','H','N','V','P','B','B','G','H','T','K','R'},//10
			{'B','D','X','O','I','F','O','K','Z','C','D','I','Z','J','R','N','D','S'},
			{'A','J','F','D','V','A','Q','G','K','E','M','V','P','P','E','N','N','Y'},
			{'G','T','B','S','N','A','X','L','G','Q','M','F','C','X','V','T','W','O'},
			{'W','B','X','S','C','R','T','Z','V','W','H','L','A','A','Q','D','N','X'},
			{'D','F','K','V','H','Y','D','A','E','J','M','Y','W','F','U','D','L','V'},
			{'Y','L','S','J','H','W','W','H','Z','Z','M','S','D','F','M','R','K','B'},
			{'L','C','D','G','I','Y','U','J','S','T','Q','C','Z','Q','U','C','R','K'}
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
	public void complexTextWithBigMatrixV2() {
		assertEquals(true, new Boggle(board4, "VSLMOLLA").check());
	}
	
	@Test
	public void complexTextWithBigMatrixV3() {
		assertEquals(false, new Boggle(board5, "SWSMZEAWWHJ").check());
	}

	@Test
	private void celdsNeighbordsTest() {
		Boggle boogle = new Boggle(board, " ");
		System.out.println(boogle.new Celd(1, 1).findNeighborCelds());
		System.out.println(boogle.new Celd(0, 0).findNeighborCelds());
		System.out.println(boogle.new Celd(2, 2).findNeighborCelds());
	}
	
}
