#https://leetcode.com/problems/count-subarrays-with-fixed-bounds/
#You are given an integer array nums and two integers minK and maxK.
#A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
#	The minimum value in the subarray is equal to minK.
#	The maximum value in the subarray is equal to maxK.
#Return the number of fixed-bound subarrays.
#A subarray is a contiguous part of an array.
# 
#Example 1:
#Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
#Output: 2
#Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
#Example 2:
#Input: nums = [1,1,1,1], minK = 1, maxK = 1
#Output: 10
#Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
# 
#Constraints:
#	2 <= nums.length <= 105
#	1 <= nums[i], minK, maxK <= 106
class Solution(object):
    def countSubarrays(self, nums, minK, maxK):
        """
        :type nums: List[int]
        :type minK: int
        :type maxK: int
        :rtype: int
        """
        n = len(nums)
        if n < 1:
            return 0
        ans = 0
        for i in range(n):
            for j in range(i, n):
                if min(nums[i:j+1]) == minK and max(nums[i:j+1]) == maxK:
                    ans += 1
        return ans
