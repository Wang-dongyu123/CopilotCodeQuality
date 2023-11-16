#https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/
#There are n oranges in the kitchen and you decided to eat some of these oranges every day as follows:
#Eat one orange.
#If the number of remaining oranges n is divisible by 2 then you can eat n / 2 oranges.
#If the number of remaining oranges n is divisible by 3 then you can eat 2 * (n / 3) oranges.
#You can only choose one of the actions per day.
#Given the integer n, return the minimum number of days to eat n oranges.


class Solution(object):
    def minDays(self, n):
        """
        :type n: int
        :rtype: int
        """ 
        @lru_cache(None)
        def dp(n):
            if n <= 1:
                return n
            return 1 + min(n%2 + dp(n//2), n%3 + dp(n//3))
        return dp(n)
        
        
    