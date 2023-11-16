#https://leetcode.com/problems/global-and-local-inversions/
#You are given an integer array nums of length n which represents a permutation of all the integers in the range [0, n - 1].
#The number of global inversions is the number of the different pairs (i, j) where:
#	0 <= i < j < n
#	nums[i] > nums[j]
#The number of local inversions is the number of indices i where:
#	0 <= i < n - 1
#	nums[i] > nums[i + 1]
#Return true if the number of global inversions is equal to the number of local inversions.
# 
#Example 1:
#Input: nums = [1,0,2]
#Output: true
#Explanation: There is 1 global inversion and 1 local inversion.
#Example 2:
#Input: nums = [1,2,0]
#Output: false
#Explanation: There are 2 global inversions and 1 local inversion.
# 
#Constraints:
#	n == nums.length
#	1 <= n <= 105
#	0 <= nums[i] < n
#	All the integers of nums are unique.
#	nums is a permutation of all the numbers in the range [0, n - 1].
class Solution(object):
    def isIdealPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        #Solution
        #1. Initialize the result to 0
        #2. For each number in nums, check if it is 1
        #3. If it is, check if the number is surrounded by 0's
        #4. If it is, increase the result by 1
        #5. Return the result
        #
        #Example:
        #nums: [1,0,2]
        #ret: true
        #
        #Time complexity: O(n^2)
        #Space complexity: O(n)
        
        ret = 0
        for i in range(len(nums)):
            for j in range(len(nums[i])):
                if nums[i][j] == 1:
                    if self.check(nums, i, j):
                        ret += 1
        return ret