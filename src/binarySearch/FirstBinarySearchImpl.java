package binarySearch;

public class FirstBinarySearchImpl {
	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12,15,18};
		int result = new FirstBinarySearchImpl().search(nums, 322);
		System.out.println("Result " + result);
	}

	public int search(int[] nums, int target) {
		return searchRecur(nums, target, 0, nums.length - 1);
	}
	
	
	public int searchRecur(int[] nums, int target, int low, int high) {
		System.out.println("hight" + high + "low" + low);
		if (low > high) return -1;
		
		int idxMiddle = low + (high - low) / 2;
		if (target == nums[idxMiddle]) {
			return idxMiddle;
		}
		else if (target < nums[idxMiddle]) {
			return searchRecur(nums, target, low, idxMiddle - 1);
		} else {
			return searchRecur(nums, target, idxMiddle + 1, high);
		} 
	}
	
}
