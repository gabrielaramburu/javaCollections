package binarySearch;

public class GuessTheNumber {

	public static void main(String[] args) {
		GuessTheNumber guess = new GuessTheNumber();
		System.out.println(guess.guessNumber(10));
	}

	public int guessNumber(int n) {
		return binarySearch(n, 1, (int) (Math.pow(2, 31) - 1));
	}

	public int binarySearch(int target, int low, int high) {
		int result;
		System.out.println("target= " + target + ", low " + low + ", high " + high);
		int res = guess(target);
		if (res == 0) {
			result = target;
			return result;
		}
			
		if (res == -1) {
			high = target  - 1;
			result = binarySearch(low + ((high - low)/2), low, high);
		}
		else
			result = binarySearch(low + ((high - low)/2), target + 1, high);

		return result;
	}

	int guess(int num) {
		int piked = 6;
		if (num == piked)
			return 0;
		if (piked < num)
			return -1;
		else
			return 1;
	}
}
