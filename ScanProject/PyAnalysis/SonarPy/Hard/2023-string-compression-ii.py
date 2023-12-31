#https://leetcode.com/problems/string-compression-ii/
#Run-length encoding is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "aabccc" we replace "aa" by "a2" and replace "ccc" by "c3". Thus the compressed string becomes "a2bc3".
#Notice that in this problem, we are not adding '1' after single characters.
#Given a string s and an integer k. You need to delete at most k characters from s such that the run-length encoded version of s has minimum length.
#Find the minimum length of the run-length encoded version of s after deleting at most k characters.


class Solution(object):
    def getLengthOfOptimalCompression(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """ 
        def getLength(s):
            ans = 0
            cnt = 0
            prev = ''
            for c in s:
                if c == prev:
                    cnt += 1
                else:
                    ans += 1 + (0 if cnt == 1 else len(str(cnt)))
                    cnt = 1
                    prev = c
            ans += 1 + (0 if cnt == 1 else len(str(cnt)))
            return ans

        @lru_cache(None)
        def dp(i, k):
            if k < 0:
                return float('inf')
            if i < 0:
                return 0
            if k >= i:
                return 0
            return min(dp(i-1, k-1), getLength(s[:i]) + dp(i-1, k))

        return dp(len(s), k) - 1
        
         
        
        
    