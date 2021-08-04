package recursion;

public class Fibonacci {

	//1,1,2,3,5,8,13
	public static void main(String[] args) {
		Fibonacci fibo = new Fibonacci();
		System.out.println(fibo.fibonacci(20));
	}

	private int fibonacci(int i) {
		return fibonacci(0,1, i);
	}
	
	private int fibonacci(int ant, int sig, int max) {
		if (ant > max) return sig;
		
		System.out.println(ant);
		return fibonacci(ant + sig, ant, max);
	}

}
