package main.java.Medium;

import java.util.Arrays;

/**https://leetcode.com/problems/wiggle-sort-ii/ */
//Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
//You may assume the input array always has a valid answer.
// 
//Example 1:
//Input: nums = [1,5,1,1,6,4]
//Output: [1,6,1,5,1,4]
//Explanation: [1,4,1,5,1,6] is also accepted.
//Example 2:
//Input: nums = [1,3,2,2,3,1]
//Output: [2,3,1,3,1,2]
// 
//Constraints:
//	1 <= nums.length <= 5 * 104
//	0 <= nums[i] <= 5000
//	It is guaranteed that there will be an answer for the given input nums.
// 
//Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
class Solution474 {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        System.arraycopy(nums, 0, temp, 0, len);
        Arrays.sort(temp);
        int l = (len + 1) / 2 - 1, r = len - 1;
        for(int i = 0; i < len; i++) {
            if((i & 1) == 0) nums[i] = temp[l--];
            else nums[i] = temp[r--];
        }
    }
}