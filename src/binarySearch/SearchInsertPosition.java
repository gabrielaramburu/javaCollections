package binarySearch;

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
