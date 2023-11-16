#https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/
#Given an array of integers cost and an integer target, return the maximum integer you can paint under the following rules:
#The cost of painting a digit (i + 1) is given by cost[i] (0-indexed).
#The total cost used must be equal to target.
#The integer does not have 0 digits.
#Since the answer may be very large, return it as a string. If there is no way to paint any integer given the condition, return "0".


class Solution(object):
    def largestNumber(self, cost, target):
        """
        :type cost: List[int]
        :type target: int
        :rtype: str
        """     
        #Approach: Recursion with Memoization
        #Time Complexity: O(t * n)
        #Space Complexity: O(t)
        #where, t is the target and n is the length of cost array
        
        def paint(t):
            if t == 0:
                return 0
            
            if t < 0:
                return -float('inf')
            
            if t in self.memo:
                return self.memo[t]
            
            res = -float('inf')
            for i in range(len(cost)):
                res = max(res, 1 + paint(t - cost[i]))
                
            self.memo[t] = res
            return self.memo[t]
        
        self.memo = {}
        res = paint(target)
        if res < 0:
            return '0'
        
        res = str(res)
        res = list(res)
        res.sort()
        res.reverse()
        res = ''.join(res)
        return res
    