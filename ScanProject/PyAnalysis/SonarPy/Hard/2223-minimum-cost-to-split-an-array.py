#https://leetcode.com/problems/minimum-cost-to-split-an-array/
#You are given an integer array nums and an integer k.
#Split the array into some number of non-empty subarrays. The cost of a split is the sum of the importance value of each subarray in the split.
#Let trimmed(subarray) be the version of the subarray where all numbers which appear only once are removed.
#For example, trimmed([3,1,2,4,3,4]) = [3,4,3,4].
#The importance value of a subarray is k + trimmed(subarray).length.
#For example, if a subarray is [1,2,3,3,3,4,4], then trimmed([1,2,3,3,3,4,4]) = [3,3,3,4,4].The importance value of this subarray will be k + 5.
#Return the minimum possible cost of a split of nums.
#A subarray is a contiguous non-empty sequence of elements within an array.


class Solution(object):
    def minCost(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """       
        if not nums:
            return 0
        if k==1:
            return len(nums)
        if k==len(nums):
            return 1
        result = []
        for i in range(len(nums)-k+1):
            result.append(len(nums[i:i+k]))
        return min(result)

        
        
    