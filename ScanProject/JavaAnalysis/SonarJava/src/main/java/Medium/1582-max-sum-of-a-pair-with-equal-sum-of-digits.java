package main.java.Medium;

/**https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/ */
//You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
//Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.
// 
//Example 1:
//Input: nums = [18,43,36,13,7]
//Output: 54
//Explanation: The pairs (i, j) that satisfy the conditions are:
//- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
//- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
//So the maximum sum that we can obtain is 54.
//Example 2:
//Input: nums = [10,12,19,14]
//Output: -1
//Explanation: There are no two numbers that satisfy the conditions, so we return -1.
// 
//Constraints:
//	1 <= nums.length <= 105
//	1 <= nums[i] <= 109
class Solution326 {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        int[] cnt = new int[100];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1];
            int sum = 0, x = nums[i - 1];
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            pre[i] += ++cnt[sum];
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (pre[mid] < pre[i]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (pre[l] < pre[i]) {
                max = Math.max(max, nums[i - 1] + nums[l - 1]);
            }
        }
        return max == 0 ? -1 : max;
    }
}