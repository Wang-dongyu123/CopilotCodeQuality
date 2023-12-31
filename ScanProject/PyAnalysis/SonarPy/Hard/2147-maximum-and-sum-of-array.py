#https://leetcode.com/problems/maximum-and-sum-of-array/
#You are given an integer array nums of length n and an integer numSlots such that 2 * numSlots >= n. There are numSlots slots numbered from 1 to numSlots.
#You have to place all n integers into the slots such that each slot contains at most two numbers. The AND sum of a given placement is the sum of the bitwise AND of every number with its respective slot number.
#For example, the AND sum of placing the numbers [1, 3] into slot 1 and [4, 6] into slot 2 is equal to (1 AND 1) + (3 AND 1) + (4 AND 2) + (6 AND 2) = 1 + 1 + 0 + 2 = 4.
#Return the maximum possible AND sum of nums given numSlots slots.


class Solution(object):
    def maximumANDSum(self, nums, numSlots):
        """
        :type nums: List[int]
        :type numSlots: int
        :rtype: int
        """
        n = len(nums)
        presum = [0]
        for x in nums:
            presum.append(presum[-1] + x)
        ans = presum[-1] * 2 ** (numSlots - n)
        for i in range(n):
            for j in range(i+1, n):
                ans = max(ans, presum[j+1] - presum[i])
        return ans
        
        
    