#https://leetcode.com/problems/palindrome-partitioning-iv/
#Given a string s, return true if it is possible to split the string s into three non-empty palindromic substrings. Otherwise, return false.
#A string is said to be palindrome if it the same string when reversed.


class Solution(object):
    def checkPartitioning(self, s):
        """
        :type s: str
        :rtype: bool
        """       
        
        @lru_cache(None)
        def isPali(i, j):
            if i >= j:
                return True
            if s[i] != s[j]:
                return False
            return isPali(i + 1, j - 1)
        
        n = len(s)
        for i in range(1, n - 1):
            for j in range(i, n - 1):
                if isPali(0, i - 1) and isPali(i, j) and isPali(j + 1, n - 1):
                    return True
        return False
        
        
    