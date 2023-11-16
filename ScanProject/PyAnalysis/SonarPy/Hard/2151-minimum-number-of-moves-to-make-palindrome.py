#https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/
#You are given a string s consisting only of lowercase English letters.
#In one move, you can select any two adjacent characters of s and swap them.
#Return the minimum number of moves needed to make s a palindrome.
#Note that the input will be generated such that s can always be converted to a palindrome.


class Solution(object):
    def minMovesToMakePalindrome(self, s):
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
            ans = max(ans, i - seen[mask])
            for j in range(10):
                ans = max(ans, i - seen[mask ^ (1 << j)])
            seen[mask] = min(seen[mask], i)
        return n - 1 - ans
        
        
    