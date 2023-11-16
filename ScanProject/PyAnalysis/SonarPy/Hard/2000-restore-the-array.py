#https://leetcode.com/problems/restore-the-array/
#A program was supposed to print an array of integers. The program forgot to print whitespaces and the array is printed as a string of digits s and all we know is that all integers in the array were in the range [1, k] and there are no leading zeros in the array.
#Given the string s and the integer k, return the number of the possible arrays that can be printed as s using the mentioned program. Since the answer may be very large, return it modulo 10^9 + 7.


class Solution(object):
    def numberOfArrays(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """ 
        #Approach: Dynamic Programming
        #Time Complexity: O(n * log k)
        #Space Complexity: O(n)
        #where, n is the length of s
        
        dp = [0 for _ in range(len(s) + 1)]
        dp[len(s)] = 1
        
        for i in range(len(s) - 1, -1, -1):
            if s[i] == '0':
                continue
            
            for j in range(i + 1, len(s) + 1):
                if int(s[i : j]) > k:
                    break
                dp[i] += dp[j]
                dp[i] %= (10 ** 9 + 7)
                
        return dp[0]
    
        #Approach: Recursion with Memoization
        #Time Complexity: O(n * log k)
        #Space Complexity: O(n)
        #where, n is the length of s

        
        
        
    