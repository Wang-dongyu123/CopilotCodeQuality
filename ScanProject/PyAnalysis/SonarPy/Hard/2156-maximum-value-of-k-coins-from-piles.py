#https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/
#There are n piles of coins on a table. Each pile consists of a positive number of coins of assorted denominations.
#In one move, you can choose any coin on top of any pile, remove it, and add it to your wallet.
#Given a list piles, where piles[i] is a list of integers denoting the composition of the ith pile from top to bottom, and a positive integer k, return the maximum total value of coins you can have in your wallet if you choose exactly k coins optimally.


class Solution(object):
    def maxValueOfCoins(self, piles, k):
        """
        :type piles: List[List[int]]
        :type k: int
        :rtype: int
        """
        n = len(piles)
        presum = [0]
        for x in piles:
            presum.append(presum[-1] + x[-1])
        @lru_cache(None)
        def dp(i, k):
            if i == n:
                return 0
            if k == 0:
                return 0
            res = 0
            for j in range(len(piles[i])):
                res = max(res, presum[i+1] - presum[i] - dp(i+1, k-1))
            return res
        return dp(0, k)
        
        
    