#https://leetcode.com/problems/find-longest-awesome-substring/
#You are given a string s. An awesome substring is a non-empty substring of s such that we can make any number of swaps in order to make it a palindrome.
#Return the length of the maximum length awesome substring of s.


class Solution(object):
    def longestAwesome(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        ans = 0
        seen = [-1] + [n] * 1023
        mask = 0
        for i in range(n):
            mask ^= 1 << int(s[i])
            ans = max
        
        
    