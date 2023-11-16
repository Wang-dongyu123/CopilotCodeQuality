package main.java.Medium;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/find-all-good-indices/ */
//You are given a 0-indexed integer array nums of size n and a positive integer k.
//We call an index i in the range k <= i < n - k good if the following conditions are satisfied:
//	The k elements that are just before the index i are in non-increasing order.
//	The k elements that are just after the index i are in non-decreasing order.
//Return an array of all good indices sorted in increasing order.
// 
//Example 1:
//Input: nums = [2,1,1,1,3,4,1], k = 2
//Output: [2,3]
//Explanation: There are two good indices in the array:
//- Index 2. The subarray [2,1] is in non-increasing order, and the subarray [1,3] is in non-decreasing order.
//- Index 3. The subarray [1,1] is in non-increasing order, and the subarray [3,4] is in non-decreasing order.
//Note that the index 4 is not good because [4,1] is not non-decreasing.
//Example 2:
//Input: nums = [2,1,1,2], k = 2
//Output: []
//Explanation: There are no good indices in this array.
// 
//Constraints:
//	n == nums.length
//	3 <= n <= 105
//	1 <= nums[i] <= 106
//	1 <= k <= n / 2
class Solution354 {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = k; i < n - k; i++) {
            boolean valid = true;
            for (int j = 1; j <= k; j++) {
                if (nums[i - j] < nums[i - j + 1]) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                continue;
            }
            for (int j = 1; j <= k; j++) {
                if (nums[i + j] > nums[i + j - 1]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                res.add(i);
            }
        }
        return res;

    }
}