#https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/
#Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an integer k, return the kth (1-based) smallest product of nums1[i] * nums2[j] where 0 <= i < nums1.length and 0 <= j < nums2.length.


class Solution(object):
    def kthSmallestProduct(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: int
        """
        
        n1, n2 = len(nums1), len(nums2)
        if n1 > n2:
            nums1, nums2 = nums2, nums1
            n1, n2 = n2, n1
        p1 = bisect.bisect_left(nums1, 0)
        p2 = bisect.bisect_left(nums2, 0)
        neg = p1 * p2
        pos = n1 * n2 - (n1 - p1) * (n2 - p2)
        if k <= neg:
            return self.findKthSmallestProduct(nums1, nums2, k, True)
        elif k <= neg + pos:
            return 0
        else:
            return self.findKthSmallestProduct(nums1, nums2, k - neg - pos, False)

        
    