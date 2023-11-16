#https://leetcode.com/problems/minimum-total-cost-to-make-arrays-unequal/
#You are given two 0-indexed integer arrays nums1 and nums2, of equal length n.
#In one operation, you can swap the values of any two indices of nums1. The cost of this operation is the sum of the indices.
#Find the minimum total cost of performing the given operation any number of times such that nums1[i] != nums2[i] for all 0 <= i <= n - 1 after performing all the operations.
#Return the minimum total cost such that nums1 and nums2 satisfy the above condition. In case it is not possible, return -1.


class Solution(object):
    def minimumTotalCost(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: int
        """
        n = len(nums1)
        nums1.sort()
        nums2.sort()
        presum1 = [0]
        presum2 = [0]
        for x in nums1:
            presum1.append(presum1[-1] + x)
        for x in nums2:
            presum2.append(presum2[-1] + x)
        res = float('inf')
        for i in range(n+1):
            res = min(res, presum1[-1] - presum1[i] + presum2[i])
        return res if res != float('inf') else -1
        
        
        
    