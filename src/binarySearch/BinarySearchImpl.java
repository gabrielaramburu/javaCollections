package binarySearch;

public class BinarySearchImpl {
	public static void main(String[] args) {
		int target = Integer.valueOf(args[0]);
		
		
		BinarySearchImpl bs = new BinarySearchImpl();
		bs.new TestCase("TestCase0", new int[] {}, 88, -1).execute();
		bs.new TestCase("TestCase1", new int[] {1,3,5,6,7,8,9,55,65,67,88,99} , 88, 10).execute();
		bs.new TestCase("TextCase2", new int[] {1,4,5}, 1, 0).execute();
		bs.new TestCase("TextCase2", new int[] {1,4,5}, 4, 1).execute();
		bs.new TestCase("TextCase2", new int[] {1,4,5}, 5, 2).execute();
	}
	
	
	public int search(int target, int[] data) {
		return searchRecursive(target, data,0, data.length - 1);
	}
	
	private int searchRecursive(int target, int[] data, int init, int end) {
		//System.out.println(" init end " + init + " " + end);
		if (end < init) return -1;
		int middle = init + (end - init) / 2;
		if (data[middle] == target) return middle;
		else if (data[middle] > target) return searchRecursive(target, data,init,middle - 1);
		else return searchRecursive(target, data, middle + 1, end);
	}
	
	private void pause(int mil) {
		try {
			Thread.sleep(mil);
		} catch (InterruptedException e) {
		
		}
	}
	
	
	class TestCase {
		int[] data;
		int target;
		int expectedResult;
		String name;
		
		public TestCase(String name, int[] data, int target, int expResult) {
			this.data = data;
			this.target = target;
			this.expectedResult = expResult;
			this.name = name;
		}
		
		public void execute() {
			int result =  new BinarySearchImpl().search(this.target, this.data);
			System.out.printf("%s: target value  %d, expected response: %d, responde: %d %n",this.name, this.target, this.expectedResult, result);
			
		}
	}
	
}
