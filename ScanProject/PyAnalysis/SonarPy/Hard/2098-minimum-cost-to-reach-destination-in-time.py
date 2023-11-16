#https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/
#There is a country of n cities numbered from 0 to n - 1 where all the cities are connected by bi-directional roads. The roads are represented as a 2D integer array edges where edges[i] = [xi, yi, timei] denotes a road between cities xi and yi that takes timei minutes to travel. There may be multiple roads of differing travel times connecting the same two cities, but no road connects a city to itself.
#Each time you pass through a city, you must pay a passing fee. This is represented as a 0-indexed integer array passingFees of length n where passingFees[j] is the amount of dollars you must pay when you pass through city j.
#In the beginning, you are at city 0 and want to reach city n - 1 in maxTime minutes or less. The cost of your journey is the summation of passing fees for each city that you passed through at some moment of your journey (including the source and destination cities).
#Given maxTime, edges, and passingFees, return the minimum cost to complete your journey, or -1 if you cannot complete it within maxTime minutes.


class Solution(object):
    def minCost(self, maxTime, edges, passingFees):
        """
        :type maxTime: int
        :type edges: List[List[int]]
        :type passingFees: List[int]
        :rtype: int
        """
        n = len(passingFees)
        dp = [[float('inf')] * n for _ in range(maxTime + 1)]
        dp[0][0] = passingFees[0]
        for t in range(maxTime + 1):
            for i, j, c in edges:
                if t + c <= maxTime:
                    dp[t+c][j] = min(dp[t+c][j], dp[t][i] + passingFees[j])
                    dp[t+c][i] = min(dp[t+c][i], dp[t][j] + passingFees[i])
        res = min(dp[maxTime])
        return res if res < float('inf') else -1
        
        
    