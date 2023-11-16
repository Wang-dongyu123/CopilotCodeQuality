#https://leetcode.com/problems/find-unique-binary-string/
#Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.
# 
#Example 1:
#Input: nums = ["01","10"]
#Output: "11"
#Explanation: "11" does not appear in nums. "00" would also be correct.
#Example 2:
#Input: nums = ["00","01"]
#Output: "11"
#Explanation: "11" does not appear in nums. "10" would also be correct.
#Example 3:
#Input: nums = ["111","011","001"]
#Output: "101"
#Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
# 
#Constraints:
#	n == nums.length
#	1 <= n <= 16
#	nums[i].length == n
#	nums[i] is either '0' or '1'.
#	All the strings of nums are unique.
class Solution(object):
    def findDifferentBinaryString(self, nums):
        """
        :type nums: List[str]
        :rtype: str
        """
        return ''.join('0' if nums[i][i] == '1' else '1' for i in range(len(nums)))
