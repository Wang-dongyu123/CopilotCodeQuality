#https://leetcode.com/problems/longest-happy-prefix/
#A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).
#Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.


class Solution(object):
    def longestPrefix(self, s):
        """
        :type s: str
        :rtype: str
        """
        #Approach: Rolling Hash
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        #where, n is the length of s
        
        mod = 10 ** 9 + 7
        n = len(s)
        
        prefixHash = 0
        suffixHash = 0
        power = 1
        
        res = 0
        for i in range(n - 1):
            prefixHash = (prefixHash * 26 + (ord(s[i]) - ord('a'))) % mod
            suffixHash = (suffixHash + (ord(s[n - 1 - i]) - ord('a')) * power) % mod
            power = power * 26 % mod
            
            if prefixHash == suffixHash:
                res = i + 1
                
        return s[:res]
    
        #Approach: KMP
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the length of s
            
        
        
        
        
    