#https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-substrings/
#You are given a 0-indexed string s and are tasked with finding two non-intersecting palindromic substrings of odd length such that the product of their lengths is maximized.
#More formally, you want to choose four integers i, j, k, l such that 0 <= i <= j < k <= l < s.length and both the substrings s[i...j] and s[k...l] are palindromes and have odd lengths. s[i...j] denotes a substring from index i to index j inclusive.
#Return the maximum possible product of the lengths of the two non-intersecting palindromic substrings.
#A palindrome is a string that is the same forward and backward. A substring is a contiguous sequence of characters in a string.


class Solution(object):
    def maxProduct(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        n = len(s)
        ans = 0
        dp = [0] * (1 << n)
        for mask in range(1, 1 << n):
            i = 0
            while not (1 << i) & mask:
                i += 1
            j = n - 1
            while not (1 << j) & mask:
                j -= 1
            if i == j:
                dp[mask] = dp[mask ^ (1 << i)] + 1
            else:
                dp[mask] = dp[mask ^ (1 << i) ^ (1 << j)] + 2
            if dp[mask] == (mask.bit_length() + 1) // 2:
                ans = max(ans, dp[mask])
        return ans * (n - ans)
        
    