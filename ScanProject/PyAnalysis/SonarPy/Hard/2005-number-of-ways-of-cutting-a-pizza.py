#https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/
#Given a rectangular pizza represented as a rows x cols matrix containing the following characters: 'A' (an apple) and '.' (empty cell) and given the integer k. You have to cut the pizza into k pieces using k-1 cuts. 
#For each cut you choose the direction: vertical or horizontal, then you choose a cut position at the cell boundary and cut the pizza into two pieces. If you cut the pizza vertically, give the left part of the pizza to a person. If you cut the pizza horizontally, give the upper part of the pizza to a person. Give the last piece of pizza to the last person.
#Return the number of ways of cutting the pizza such that each piece contains at least one apple. Since the answer can be a huge number, return this modulo 10^9 + 7.


class Solution(object):
    def ways(self, pizza, k):
        """
        :type pizza: List[str]
        :type k: int
        :rtype: int
        """     
        #Approach: Recursion with Memoization
        #Time Complexity: O(m * n * k * (m + n))
        #Space Complexity: O(m * n * k)
        #where, m and n are the dimensions of the pizza
        #and, k is the number of cuts
        #Note: 10^9 + 7 is a prime number, so Fermat's Little Theorem can be used.
        
        def countApples(i, j):
            res = 0
            for x in range(i, m):
                for y in range(j, n):
                    if pizza[x][y] == 'A':
                        res += 1
            return res
        
        def countWays(i, j, k):
            if k == 0:
                return 1
            
            if (i, j, k) in self.memo:
                return self.memo[(i, j, k)]
            
            res = 0
            for x in range(i + 1, m):
                if countApples(i, j) - countApples(x, j) > 0:
                    res += countWays(x, j, k - 1)
                    res %= (10 ** 9 + 7)
                    
            for y in range(j + 1, n):
                if countApples(i, j) - countApples(i, y) > 0:
                    res += countWays(i, y, k - 1)
                    res %= (10 ** 9 + 7)
                    
            self.memo[(i, j, k)] = res
            return self.memo[(i, j, k)]
        
        m = len(pizza)
        n = len(pizza[0])
        
        self.memo = {}
        return countWays(0, 0, k - 1) % (10 ** 9 + 7)
    
        #Approach: Recursion with Memoization
        #Time Complexity: O(m * n * k * (m + n))
        #Space Complexity: O(m * n * k)
        #where, m and n are the dimensions of the pizza
        #and, k is the number of cuts
        #Note: 10^9 + 7 is a prime number, so Fermat's Little Theorem can be used.


        
        
        
    