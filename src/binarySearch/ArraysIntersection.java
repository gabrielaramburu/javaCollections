package binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraysIntersection {
	
	public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> inter = new HashMap<Integer, Integer>();
        int[] shortestArray, longestArray;
        if (nums1.length <= nums2.length) {
            shortestArray = nums1;longestArray = nums2;
        } else {
            shortestArray = nums2;longestArray = nums1;
        }
        Arrays.sort(shortestArray);
        Arrays.stream(longestArray).forEach(target -> {
            boolean found = binarySearch(shortestArray, target, 0, shortestArray.length - 1);
            if (found) inter.put((Integer)target, (Integer)target);
        });
        return inter.values().stream().mapToInt(val->val).toArray();
        
    }
    
    public boolean binarySearch(int[] nums, int target, int low, int high) {
        boolean result;
        if (high < low) return false; 
        
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] > target)
           result = binarySearch(nums, target, 0, mid - 1); 
        else {
           result = binarySearch(nums, target, mid + 1, high);
        }
        return result;
    }

}
