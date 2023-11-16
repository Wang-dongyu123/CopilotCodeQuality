#https://leetcode.com/problems/count-number-of-special-subsequences/
#A sequence is special if it consists of a positive number of 0s, followed by a positive number of 1s, then a positive number of 2s.
#For example, [0,1,2] and [0,0,1,1,1,2] are special.
#In contrast, [2,1,0], [1], and [0,1,2,0] are not special.
#Given an array nums (consisting of only integers 0, 1, and 2), return the number of different subsequences that are special. Since the answer may be very large, return it modulo 109 + 7.
#A subsequence of an array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements. Two subsequences are different if the set of indices chosen are different.


class Solution(object):
    def countSpecialSubsequences(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """ 
        dp = [1] + [0] * 3
        for num in nums:
            dp[num + 1] = (dp[num] + dp[num + 1] * 2) % (10**9 + 7)
        return dp[-1]

        
        
    