#https://leetcode.com/problems/count-anagrams/
#You are given a string s containing one or more words. Every consecutive pair of words is separated by a single space ' '.
#A string t is an anagram of string s if the ith word of t is a permutation of the ith word of s.
#For example, "acb dfe" is an anagram of "abc def", but "def cab" and "adc bef" are not.
#Return the number of distinct anagrams of s. Since the answer may be very large, return it modulo 10^9 + 7.


class Solution(object):
    def countAnagrams(self, s):
        """
        :type s: str
        :rtype: int
        """ 
        n = len(s)
        ans = 0
        seen = [-1] + [n] * 1023
        mask = 0
        for i in range(n):
            mask ^= 1 << ord(s[i]) - ord('a')
            ans += i - seen[mask]
            for j in range(10):
                ans += i - seen[mask ^ (1 << j)]
            seen[mask] = min(seen[mask], i)
        return ans % (10**9 + 7)

        
        
        
    