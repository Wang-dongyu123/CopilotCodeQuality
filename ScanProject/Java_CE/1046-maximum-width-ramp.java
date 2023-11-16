package main.java.Medium;

/**https://leetcode.com/problems/maximum-width-ramp/ */
//A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.
//Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.


class MaximumWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] left = new int[n], right = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            left[i] = Math.min(left[i - 1], nums[i]);
        }
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = Math.max(right[i + 1], nums[i]);
        }
        int ans = 0;
        for (int i = 0, j = 0; i < n; ++i) {
            while (j < n && left[i] <= right[j]) {
                ans = Math.max(ans, j - i);
                ++j;
            }
        }
        return ans;
        
    }
}

    