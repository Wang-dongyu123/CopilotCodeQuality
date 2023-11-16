#https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/
#You are given a string s and a positive integer k.
#Select a set of non-overlapping substrings from the string s that satisfy the following conditions:
#The length of each substring is at least k.
#Each substring is a palindrome.
#Return the maximum number of substrings in an optimal selection.
#A substring is a contiguous sequence of characters within a string.


class Solution(object):
    def maxPalindromes(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        n = len(s)
        ans = 0
        seen = [-1] + [n] * 1023
        mask = 0
        for i in range(n):
            mask ^= 1 << int(s[i])
            seen[mask] = min(seen[mask], i)
            for j in range(10):
                ans += seen[mask ^ (1 << j)] <= i - k
        return ans
        
        
    