#https://leetcode.com/problems/substring-with-largest-variance/
#The variance of a string is defined as the largest difference between the number of occurrences of any 2 characters present in the string. Note the two characters may or may not be the same.
#Given a string s consisting of lowercase English letters only, return the largest variance possible among all substrings of s.
#A substring is a contiguous sequence of characters within a string.


class Solution(object):
    def largestVariance(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        ans = 0
        for i in range(n):
            cnt = [0] * 26
            for j in range(i, n):
                cnt[ord(s[j]) - ord('a')] += 1
                ans = max(ans, max(cnt) - min(x for x in cnt if x > 0))
        return ans
        
        
    