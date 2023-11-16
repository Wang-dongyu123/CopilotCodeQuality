#https://leetcode.com/problems/sum-of-scores-of-built-strings/
#You are building a string s of length n one character at a time, prepending each new character to the front of the string. The strings are labeled from 1 to n, where the string with length i is labeled si.
#For example, for s = "abaca", s1 == "a", s2 == "ca", s3 == "aca", etc.
#The score of si is the length of the longest common prefix between si and sn (Note that s == sn).
#Given the final string s, return the sum of the score of every si.


class Solution(object):
    def sumScores(self, s):
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
            ans += i - seen[mask]
            for j in range(10):
                ans += i - seen[mask ^ (1 << j)]
            seen[mask] = min(seen[mask], i)
        return ans
        
        
    