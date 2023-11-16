package main.java.Medium;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/ */
//You are given an integer array nums. A number x is lonely when it appears only once, and no adjacent numbers (i.e. x + 1 and x - 1) appear in the array.
//Return all lonely numbers in nums. You may return the answer in any order.
// 
//Example 1:
//Input: nums = [10,6,5,8]
//Output: [10,8]
//Explanation: 
//- 10 is a lonely number since it appears exactly once and 9 and 11 does not appear in nums.
//- 8 is a lonely number since it appears exactly once and 7 and 9 does not appear in nums.
//- 5 is not a lonely number since 6 appears in nums and vice versa.
//Hence, the lonely numbers in nums are [10, 8].
//Note that [8, 10] may also be returned.
//Example 2:
//Input: nums = [1,3,5,3]
//Output: [1,5]
//Explanation: 
//- 1 is a lonely number since it appears exactly once and 0 and 2 does not appear in nums.
//- 5 is a lonely number since it appears exactly once and 4 and 6 does not appear in nums.
//- 3 is not a lonely number since it appears twice.
//Hence, the lonely numbers in nums are [1, 5].
//Note that [5, 1] may also be returned.
// 
//Constraints:
//	1 <= nums.length <= 105
//	0 <= nums[i] <= 106
class Solution289 {
    public List<Integer> findLonely(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1];
            if (nums[i - 1] > nums[i - 2]) {
                pre[i]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] < nums[i - 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (nums[l] < nums[i - 1]) {
                if (pre[i - 1] - pre[l] == 0 && pre[i] - pre[l] == 0) {
                    res.add(nums[i - 1]);
                }
            } else {
                if (pre[i - 1] - pre[l] - 1 == 0 && pre[i] - pre[l] - 1 == 0) {
                    res.add(nums[i - 1]);
                }
            }
        }
        return res;
    }
}