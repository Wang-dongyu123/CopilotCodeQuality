#https://leetcode.com/problems/maximum-number-of-ways-to-partition-an-array/
#You are given a 0-indexed integer array nums of length n. The number of ways to partition nums is the number of pivot indices that satisfy both conditions:
#1 <= pivot < n
#nums[0] + nums[1] + ... + nums[pivot - 1] == nums[pivot] + nums[pivot + 1] + ... + nums[n - 1]
#You are also given an integer k. You can choose to change the value of one element of nums to k, or to leave the array unchanged.
#Return the maximum possible number of ways to partition nums to satisfy both conditions after changing at most one element.


class Solution(object):
    def waysToPartition(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        n = len(nums)
        presum = [0]
        for x in nums:
            presum.append(presum[-1] + x)
        right = [0] * n
        for i in range(n-1, -1, -1):
            if presum[i+1] == presum[-1] - presum[i+1]:
                right[i] = right[i+1] + 1
            else:
                right[i] = right[i+1]
        res = 0
        for i in range(n):
            res = max(res, right[i] + (presum[-1] - presum[i+1] == presum[i+1] - presum[0]))
        prefix = 0
        count = collections.Counter()
        for i in range(n-1):
            count[nums[i]] += 1
            prefix += nums[i]
            res = max(res, count[k - nums[i]] + (presum[-1] - presum[i+1] == presum[i+1] - presum[0]))
        return res
        
        
    