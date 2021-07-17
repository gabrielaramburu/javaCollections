package binarySearch;

/*
 * Given a sorted array of distinct integers and a target value, 
 * return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInsertPosition {
	
	public int searchInsert(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	public int binarySearch(int[] nums, int target, int low, int high) {
		int result;
		if (high < low)
			return low;

		int mid = low + (high - low) / 2;
		if (target == nums[mid])
			return mid;

		if (nums[mid] > target)
			result = binarySearch(nums, target, 0, mid - 1);
		else
			result = binarySearch(nums, target, mid + 1, high);

		return result;
	}
}
