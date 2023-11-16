package main.java.Medium;

import java.util.Arrays;

/**https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/ */
//You are given a 0-indexed integer array nums and an integer p. Find p pairs of indices of nums such that the maximum difference amongst all the pairs is minimized. Also, ensure no index appears more than once amongst the p pairs.
//Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.
//Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.
// 
//Example 1:
//Input: nums = [10,1,2,7,1,3], p = 2
//Output: 1
//Explanation: The first pair is formed from the indices 1 and 4, and the second pair is formed from the indices 2 and 5. 
//The maximum difference is max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1. Therefore, we return 1.
//Example 2:
//Input: nums = [4,2,1,2], p = 1
//Output: 0
//Explanation: Let the indices 1 and 3 form a pair. The difference of that pair is |2 - 2| = 0, which is the minimum we can attain.
// 
//Constraints:
//	1 <= nums.length <= 105
//	0 <= nums[i] <= 109
//	0 <= p <= (nums.length)/2
class Solution389 {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int[][] dp = new int[n + 1][p + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, p); j++) {
                for (int k = j - 1; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + (i - k) * nums[i - 1] - (prefix[i] - prefix[k]));
                }
            }
        }
        return dp[n][p];
    }
}