package recursion;

import java.util.Arrays;

public class EnglishBeggar {

	public static void main(String[] args) {
		int[] test = { 1, 2, 3, 4, 5 };
		int[] a1 = { 15 }, a2 = { 9, 6 }, a3 = { 5, 7, 3 }, a4 = { 1, 2, 3, 4, 5, 0 }, a5 = {};

		System.out.println(Arrays.equals(a1, beggars(test, 1)));
		System.out.println(Arrays.equals(a2, beggars(test, 2)));
		System.out.println(Arrays.equals(a3, beggars(test, 3)));
		System.out.println(Arrays.equals(a4, beggars(test, 6)));
		System.out.println(Arrays.equals(a5, beggars(test, 0)));
	}

	public static int[] beggars(int[] values, int n) {
		if (n > 0) return recursion(values, n, 0, 0);
		else return new int[] {};
	}

	public static int[] recursion(int[] values, int totOfBeggars, int currentPositionOnValues, int currentBugger) {
		if (currentPositionOnValues >= values.length)
			return new int[totOfBeggars];
		if (currentBugger >= totOfBeggars)
			currentBugger = 0;
		int[] tot = recursion(values, totOfBeggars, currentPositionOnValues + 1, currentBugger + 1);
		tot[currentBugger] += values[currentPositionOnValues];

		System.out.println(currentBugger);
		System.out.println(currentPositionOnValues);
		return tot;
	}
}
