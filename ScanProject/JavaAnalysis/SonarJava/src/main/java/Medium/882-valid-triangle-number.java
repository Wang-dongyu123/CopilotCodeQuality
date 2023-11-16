package main.java.Medium;

import java.util.Arrays;

/**https://leetcode.com/problems/valid-triangle-number/ */
//Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
// 
//Example 1:
//Input: nums = [2,2,3,4]
//Output: 3
//Explanation: Valid combinations are: 
//2,3,4 (using the first 2)
//2,3,4 (using the second 2)
//2,2,3
//Example 2:
//Input: nums = [4,2,3,4]
//Output: 4
// 
//Constraints:
//	1 <= nums.length <= 1000
//	0 <= nums[i] <= 1000
class Solution531 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) continue;
            int k = i + 2;
            for (int j = i + 1; j < n - 1; j++) {
                while (k < n && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                result += k - j - 1;
            }
        }
        return result;
    }
}