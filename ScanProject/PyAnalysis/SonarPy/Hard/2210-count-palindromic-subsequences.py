#https://leetcode.com/problems/count-palindromic-subsequences/
#Given a string of digits s, return the number of palindromic subsequences of s having length 5. Since the answer may be very large, return it modulo 109 + 7.
#Note:
#A string is palindromic if it reads the same forward and backward.
#A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.


class Solution(object):
    def countPalindromes(self, s):
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
            ans += sum(x > i - 1 for x in seen[mask ^ (1 << int(s[i]))])
            ans %= 10**9 + 7
            seen[mask] = i
        return ans
        
    