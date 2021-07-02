package recursion.matrixdeterminant;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SolutionTest {
	public static int[][] matrix0 = 
		{{1}};

	public static int[][] matrix1 = 
		{{1,2,3,4,5},
		{6,7,8,9,10},
		{11,12,13,14,15},
		{16,17,18,19,20},
		{21,22,23,24,25}};
		
	public static int[][] matrix2 = 
		{{3,2,-3},
		{7,-1,0},
		{2,-4,5}}; //-7
	
	public static int[][] matrix3 = 
		{{2,-3,1},
		{-3,5,7},
		{1,7,-1}}; //-146
	
	public static int[][] matrix4 = 
		{{1, 0, 3, -3},
			{2, -3, -2, 3},
		{-1, 2, 1, 2},
		{3, 2, 5, 0}}; //-80
	
	@Test
	public void sampleTests() {
		List<TestCases> tests = new ArrayList<SolutionTest.TestCases>();
		tests.add(new TestCases(matrix0, 1));
		tests.add(new TestCases(matrix1, 0));
		tests.add(new TestCases(matrix2, -7));
		tests.add(new TestCases(matrix3, -146));
		tests.add(new TestCases(matrix4, -80));
		
		for (TestCases test: tests) {
			assertEquals(test.expected, Matrix.determinant(test.mat));
		}
		Matrix.determinant(matrix3);
	}
	
	class TestCases {
		int[][] mat;
		int expected;
		
		TestCases (int [][] mat, int expected){
			this.mat = mat;
			this.expected = expected;
		}
	}
}
