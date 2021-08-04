package recursion;

import java.math.BigInteger;

public class Fibonacci_II {

	public static void main(String[] args) {
		System.out.println(fibonacci(20));
		
		System.out.println(fibonacciButtonUp(200));
	}

	public static int fibonacci(int n) {
		if (n == 1 || n == 2) return 1;
		
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static BigInteger fibonacciButtonUp(int n) {
		BigInteger result[] = new BigInteger[n];
		result[0] = new BigInteger("1");
		result[1] = new BigInteger("1");
		for (int i = 2; i < n; i++) {
			result[i] = result[i - 1].add(result[i - 2]);
		}
		return result[n - 1];
	}
}
