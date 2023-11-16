#https://leetcode.com/problems/maximum-total-beauty-of-the-gardens/
#Alice is a caretaker of n gardens and she wants to plant flowers to maximize the total beauty of all her gardens.
#You are given a 0-indexed integer array flowers of size n, where flowers[i] is the number of flowers already planted in the ith garden. Flowers that are already planted cannot be removed. You are then given another integer newFlowers, which is the maximum number of flowers that Alice can additionally plant. You are also given the integers target, full, and partial.
#A garden is considered complete if it has at least target flowers. The total beauty of the gardens is then determined as the sum of the following:
#The number of complete gardens multiplied by full.
#The minimum number of flowers in any of the incomplete gardens multiplied by partial. If there are no incomplete gardens, then this value will be 0.
#Return the maximum total beauty that Alice can obtain after planting at most newFlowers flowers.


class Solution(object):
    def maximumBeauty(self, flowers, newFlowers, target, full, partial):
        """
        :type flowers: List[int]
        :type newFlowers: int
        :type target: int
        :type full: int
        :type partial: int
        :rtype: int
        """
        n = len(flowers)
        presum = [0]
        for x in flowers:
            presum.append(presum[-1] + max(x, 0))
        res = 0
        for i in range(n):
            for j in range(i, n):
                if flowers[j] <= 0:
                    continue
                if flowers[j] == flowers[i]:
                    res = max(res, presum[j+1] - presum[i] + full * min(flowers[i], target) + partial * max(0, flowers[i] - target))
                else:
                    res = max(res, presum[j+1] - presum[i] + full * min(flowers[i], target) + partial * max(0, flowers[i] - target) + full * min(flowers[j], target) + partial * max(0, flowers[j] - target))
        return res
        
        
    