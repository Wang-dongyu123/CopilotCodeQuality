#https://leetcode.com/problems/sum-of-subsequence-widths/
#The width of a sequence is the difference between the maximum and minimum elements in the sequence.
#Given an array of integers nums, return the sum of the widths of all the non-empty subsequences of nums. Since the answer may be very large, return it modulo 109 + 7.
#A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].


class Solution(object):
    def sumSubseqWidths(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        if len(nums)==1:
            return 0
        nums.sort()
        result = 0
        for i in range(len(nums)):
            result+=nums[i]*(2**i-2**(len(nums)-i-1))
        return result%(10**9+7)

        
        
    