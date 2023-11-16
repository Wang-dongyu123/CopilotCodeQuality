#https://leetcode.com/problems/the-number-of-good-subsets/
#You are given an integer array nums. We call a subset of nums good if its product can be represented as a product of one or more distinct prime numbers.
#For example, if nums = [1, 2, 3, 4]:
#[2, 3], [1, 2, 3], and [1, 3] are good subsets with products 6 = 2*3, 6 = 2*3, and 3 = 3 respectively.
#[1, 4] and [4] are not good subsets with products 4 = 2*2 and 4 = 2*2 respectively.
#Return the number of different good subsets in nums modulo 109 + 7.
#A subset of nums is any array that can be obtained by deleting some (possibly none or all) elements from nums. Two subsets are different if and only if the chosen indices to delete are different.


class Solution(object):
    def numberOfGoodSubsets(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a
        def lcm(a, b):
            return a * b / gcd(a, b)
        MOD = 10**9 + 7
        count = [0] * 31
        for x in nums:
            count[x] += 1
        dp = [0] * (1<<10)
        dp[0] = 1
        for i in range(1, 1<<10):
            for j in range(10):
                if i & (1<<j):
                    dp[i] = (dp[i] + dp[i ^ (1<<j)] * count[j+1]) % MOD
        res = dp[(1<<10) - 1]
        for i in range(2, 31):
            if count[i] > 0:
                res = (res * pow(count[i], count[i]-1, MOD)) % MOD
        return res
        
        
    