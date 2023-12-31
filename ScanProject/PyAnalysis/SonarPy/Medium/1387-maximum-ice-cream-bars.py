#https://leetcode.com/problems/maximum-ice-cream-bars/
#It is a sweltering summer day, and a boy wants to buy some ice cream bars.
#At the store, there are n ice cream bars. You are given an array costs of length n, where costs[i] is the price of the ith ice cream bar in coins. The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible. 
#Note: The boy can buy the ice cream bars in any order.
#Return the maximum number of ice cream bars the boy can buy with coins coins.
#You must solve the problem by counting sort.
# 
#Example 1:
#Input: costs = [1,3,2,4,1], coins = 7
#Output: 4
#Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total price of 1 + 3 + 2 + 1 = 7.
#Example 2:
#Input: costs = [10,6,8,7,7,8], coins = 5
#Output: 0
#Explanation: The boy cannot afford any of the ice cream bars.
#Example 3:
#Input: costs = [1,6,3,1,2,5], coins = 20
#Output: 6
#Explanation: The boy can buy all the ice cream bars for a total price of 1 + 6 + 3 + 1 + 2 + 5 = 18.
# 
#Constraints:
#	costs.length == n
#	1 <= n <= 105
#	1 <= costs[i] <= 105
#	1 <= coins <= 108
class Solution(object):
    def maxIceCream(self, costs, coins):
        """
        :type costs: List[int]
        :type coins: int
        :rtype: int
        """
        count = [0] * (max(costs) + 1)
        for cost in costs:
            count[cost] += 1
        res, i = 0, 0
        while coins > 0 and i < len(count):
            if count[i] > 0:
                coins -= i
                res += 1
                count[i] -= 1
            else:
                i += 1
        return res