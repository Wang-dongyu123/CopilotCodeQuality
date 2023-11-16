#https://leetcode.com/problems/number-of-ways-to-wear-different-hats-to-each-other/
#There are n people and 40 types of hats labeled from 1 to 40.
#Given a 2D integer array hats, where hats[i] is a list of all hats preferred by the ith person.
#Return the number of ways that the n people wear different hats to each other.
#Since the answer may be too large, return it modulo 10^9 + 7.


class Solution(object):
    def numberWays(self, hats):
        """
        :type hats: List[List[int]]
        :rtype: int
        """     
        #Approach: Recursion with Memoization
        #Time Complexity: O(n * (2 ^ n) * h)
        #Space Complexity: O(n * (2 ^ n))
        #where, n is the number of people and h is the maximum number of hats a person can wear
        #Note: 10^9 + 7 is a prime number, so Fermat's Little Theorem can be used.
        
        def countWays(idx, mask):
            if mask == (1 << len(people)) - 1:
                return 1
            
            if idx == 41:
                return 0
            
            if (idx, mask) in self.memo:
                return self.memo[(idx, mask)]
            
            res = countWays(idx + 1, mask)
            for i in range(len(people)):
                if idx in people[i] and mask & (1 << i) == 0:
                    res += countWays(idx + 1, mask | (1 << i))
                    
            self.memo[(idx, mask)] = res % (10 ** 9 + 7)
            return self.memo[(idx, mask)]
        
        people = [[] for _ in range(41)]
        for i in range(len(hats)):
            for hat in hats[i]:
                people[hat].append(i)
        
        self.memo = {}
        return countWays(1, 0)
    
        #Approach: Recursion with Memoization
        #Time Complexity: O(n * (2 ^ n) * h)
        #Space Complexity: O(n * (2 ^ n))
        #where, n is the number of people and h is the maximum number of hats a person can wear
        #Note: 10^9 + 7 is a prime number, so Fermat's Little Theorem can be used.

        
       
        
        
        
    