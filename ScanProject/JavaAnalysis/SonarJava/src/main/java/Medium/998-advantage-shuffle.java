package main.java.Medium;

import java.util.Arrays;

/**https://leetcode.com/problems/advantage-shuffle/ */
//You are given two integer arrays nums1 and nums2 both of the same length. The advantage of nums1 with respect to nums2 is the number of indices i for which nums1[i] > nums2[i].
//Return any permutation of nums1 that maximizes its advantage with respect to nums2.
// 
//Example 1:
//Input: nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//Output: [2,11,7,15]
//Example 2:
//Input: nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//Output: [24,32,8,12]
// 
//Constraints:
//	1 <= nums1.length <= 105
//	nums2.length == nums1.length
//	0 <= nums1[i], nums2[i] <= 109
class Solution575 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        boolean[] used = new boolean[nums1.length];
        Arrays.sort(nums1);
        for (int i = 0; i < nums2.length; i++) {
            int index = binarySearch(nums1, nums2[i], used);
            if (index == -1) {
                result[i] = nums1[0];
                continue;
            }
            result[i] = nums1[index];
            used[index] = true;
        }
        return result;
    }

    private int binarySearch(int[] nums, int target, boolean[] used) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target && !used[mid]) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result == -1 ? -1 : result;
    }
}