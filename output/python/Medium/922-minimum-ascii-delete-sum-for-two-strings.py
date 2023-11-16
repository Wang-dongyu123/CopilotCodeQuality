#https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
#Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
# 
#Example 1:
#Input: s1 = "sea", s2 = "eat"
#Output: 231
#Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
#Deleting "t" from "eat" adds 116 to the sum.
#At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
#Example 2:
#Input: s1 = "delete", s2 = "leet"
#Output: 403
#Explanation: Deleting "dee" from "delete" to turn the string into "let",
#adds 100[d] + 101[e] + 101[e] to the sum.
#Deleting "e" from "leet" adds 101[e] to the sum.
#At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
#If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
# 
#Constraints:
#	1 <= s1.length, s2.length <= 1000
#	s1 and s2 consist of lowercase English letters.
class Solution(object):
    def minimumDeleteSum(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: int
        """
        #Solution
        #1. Initialize the result to 0
        #2. For each number in s1, check if it is greater than the last number in each subsequence
        #3. If it is, add the new subsequence to the result
        #4. Return the result
        #
        #Example:
        #s1: "sea", s2 = "eat"
        #ret: 231
        #
        #Time complexity: O(n^2)
        #Space complexity: O(n)
        
        ret = 0
        for num in s1:
            for i in range(len(ret)):
                if num > ret[i]:
                    ret[i] = num

        return ret