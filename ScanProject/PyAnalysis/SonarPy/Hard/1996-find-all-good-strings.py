#https://leetcode.com/problems/find-all-good-strings/
#Given the strings s1 and s2 of size n and the string evil, return the number of good strings.
#A good string has size n, it is alphabetically greater than or equal to s1, it is alphabetically smaller than or equal to s2, and it does not contain the string evil as a substring. Since the answer can be a huge number, return this modulo 10^9 + 7.


class Solution(object):
    def findGoodStrings(self, n, s1, s2, evil):
        """
        :type n: int
        :type s1: str
        :type s2: str
        :type evil: str
        :rtype: int
        """
        #Approach: Recursion with Memoization
        #Time Complexity: O(n * m * e)
        #Space Complexity: O(n * m * e)
        #where, n and m are the lengths of s1 and s2, respectively
        #and, e is the length of evil
        #Note: 10^9 + 7 is a prime number, so Fermat's Little Theorem can be used.
        
        def countStrings(idx, pref1, pref2, pref3):
            if idx == n:
                return 1
            
            if (idx, pref1, pref2, pref3) in self.memo:
                return self.memo[(idx, pref1, pref2, pref3)]
            
            res = 0
            for ch in 'abcdefghijklmnopqrstuvwxyz':
                if pref1 + ch < s1 or pref2 + ch > s2:
                    continue
                
                newPref3 = pref3
                while newPref3 > 0 and evil[newPref3] != ch:
                    newPref3 = lps[newPref3 - 1]
                    
                if evil[newPref3] == ch:
                    newPref3 += 1
                    
                res += countStrings(idx + 1, pref1 + ch, pref2 + ch, newPref3)
                
            self.memo[(idx, pref1, pref2, pref3)] = res % (10 ** 9 + 7)
            return self.memo[(idx, pref1, pref2, pref3)]
        
        #building lps array for evil
        lps = [0 for _ in range(len(evil))]
        i = 1
        j = 0
        while i < len(evil):
            if evil[i] == evil[j]:
                j += 1
                lps[i] = j
                i += 1
            elif j > 0:
                j = lps[j - 1]
            else:
                i += 1
        
        self.memo = {}
        res = countStrings(0, '', '', 0)
        return res % (10 ** 9 + 7)

            
       
        
        
       