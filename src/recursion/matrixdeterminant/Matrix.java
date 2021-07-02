package recursion.matrixdeterminant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {
	public static void main(String[] args) {
		determinant(SolutionTest.matrix0);
	}

	public static int determinant(int[][] matrix) {
		return new Matrix().calcDeterminantRecursive(matrix, 0);
	}

	private int calcDeterminantRecursive(int[][] matrix, int rowIdx) {
		if (matrix.length == 1) return matrix[0][0];
		if (matrix.length == 2) return twoXtwoMatrixDet(matrix);
		
		List<Result> determinants = new ArrayList<Result>();
		
		for (int row = 0;row < matrix.length; row++) {
			int[][] subMatrix = subMatrix(matrix, row);
			int det = calcDeterminantRecursive(subMatrix, row);
			determinants.add(new Result(det, matrix[row][0]));	
		}
		return calcDet(determinants);
	}

	private int calcDet(List<Result> determinants) {
		sign(determinants);
		
		int det = 0;
		for (Result result: determinants) 
			det += result.factor * result.detWithSigh();
		
		return det;
	}

	private int[][] subMatrix(int[][] matrix, int idxRow) {
		int newLength = matrix.length - 1;
		int newSubMatrix[][] = new int[newLength][newLength];
		int rowNewMatrix = 0;
		for (int row = 0; row < matrix.length; row++) {
			if (row != idxRow) {
				for (int col = 0; col < newLength; col++) {
					newSubMatrix[rowNewMatrix][col] = matrix[row][col + 1];
				}
			} else rowNewMatrix--;
			rowNewMatrix++;
		}
		return newSubMatrix;
	}

	private int twoXtwoMatrixDet(int[][] mat) {
		return (mat[0][0] * mat[1][1]) - (mat[1][0] * mat[0][1]); 
	}
	
	private void sign(List<Result> determinants) {
		int sign = 1;
		for (Result result: determinants) {
			result.setSign(sign);
			sign = (sign == -1) ? 1: -1;
		}
	}
	
	private void showMatrix(int[][] mat) {
		System.out.println("New matrix");
		for (int[] arr : mat) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
	class Result {
		int det;
		int factor;
		int sign;
		
		Result (int det, int factor) {
			this.det =  det;
			this.factor = factor;
		}
		
		void setSign(int sign) {
			this.sign = sign;
		}
		
		int detWithSigh() {
			return det * sign;
		}
		
		@Override
		public String toString() {
			return "[det:" + det + ", factor: " + factor + ", sign: " + sign + " ]";
		}
		
		
	}
}
