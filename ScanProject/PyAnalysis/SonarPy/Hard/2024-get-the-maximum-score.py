#https://leetcode.com/problems/get-the-maximum-score/
#You are given two sorted arrays of distinct integers nums1 and nums2.
#A valid path is defined as follows:
#Choose array nums1 or nums2 to traverse (from index-0).
#Traverse the current array from left to right.
#If you are reading any value that is present in nums1 and nums2 you are allowed to change your path to the other array. (Only one repeated value is considered in the valid path).
#The score is defined as the sum of uniques values in a valid path.
#Return the maximum score you can obtain of all possible valid paths. Since the answer may be too large, return it modulo 10^9 + 7.


class Solution(object):
    def maxSum(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: int
        """ 
        
        if not nums1 or not nums2:
            return 0
        i = j = 0
        m = len(nums1)
        n = len(nums2)
        sum1 = sum2 = 0
        while i < m or j < n:
            if i < m and j < n and nums1[i] == nums2[j]:
                sum1 = sum2 = max(sum1, sum2) + nums1[i]
                i += 1
                j += 1
            elif i < m and (j == n or nums1[i] < nums2[j]):
                sum1 += nums1[i]
                i += 1
            elif j < n and (i == m or nums1[i] > nums2[j]):
                sum2 += nums2[j]
                j += 1
        return max(sum1, sum2) % (10**9 + 7)
        
    