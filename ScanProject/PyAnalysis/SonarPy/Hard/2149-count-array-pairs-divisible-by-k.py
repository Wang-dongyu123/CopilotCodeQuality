#https://leetcode.com/problems/count-array-pairs-divisible-by-k/
#Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs (i, j) such that:
#0 <= i < j <= n - 1 and
#nums[i] * nums[j] is divisible by k.


class Solution(object):
    def countPairs(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        n = len(nums)
        presum = [0]
        for x in nums:
            presum.append(presum[-1] + x)
        count = collections.Counter()
        res = 0
        for i in range(n):
            res += count[(presum[i+1] - presum[i]) % k]
            count[(presum[i+1] - presum[i]) % k] += 1
        return res
        
        
    