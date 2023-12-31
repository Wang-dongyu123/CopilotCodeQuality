#https://leetcode.com/problems/count-good-triplets-in-an-array/
#You are given two 0-indexed arrays nums1 and nums2 of length n, both of which are permutations of [0, 1, ..., n - 1].
#A good triplet is a set of 3 distinct values which are present in increasing order by position both in nums1 and nums2. In other words, if we consider pos1v as the index of the value v in nums1 and pos2v as the index of the value v in nums2, then a good triplet will be a set (x, y, z) where 0 <= x, y, z <= n - 1, such that pos1x < pos1y < pos1z and pos2x < pos2y < pos2z.
#Return the total number of good triplets.


class Solution(object):
    def goodTriplets(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: int
        """       
        n = len(nums1)
        res = 0
        for i in range(n):
            for j in range(i+1, n):
                for k in range(j+1, n):
                    res += (nums1[i] < nums1[j] < nums1[k]) and (nums2[i] < nums2[j] < nums2[k]) and (abs(nums1[i] - nums2[i]) <= 10) and (abs(nums1[j] - nums2[j]) <= 10) and (abs(nums1[k] - nums2[k]) <= 10)
        return res
        
        
    