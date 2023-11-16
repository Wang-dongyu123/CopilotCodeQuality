#https://leetcode.com/problems/total-hamming-distance/
#The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
#Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.


class Solution(object):
    def totalHammingDistance(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        def countBits(n):
            res = 0
            while n:
                res += n & 1
                n >>= 1
            return res
        res = 0
        for i in range(len(nums)):
            for j in range(i+1,len(nums)):
                res += countBits(nums[i] ^ nums[j])
        return res
        

    