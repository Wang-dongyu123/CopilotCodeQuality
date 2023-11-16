#https://leetcode.com/problems/kth-smallest-instructions/
#Bob is standing at cell (0, 0), and he wants to reach destination: (row, column). He can only travel right and down. You are going to help Bob by providing instructions for him to reach destination.
#The instructions are represented as a string, where each character is either:
#'H', meaning move horizontally (go right), or
#'V', meaning move vertically (go down).
#Multiple instructions will lead Bob to destination. For example, if destination is (2, 3), both "HHHVV" and "HVHVH" are valid instructions.
#However, Bob is very picky. Bob has a lucky number k, and he wants the kth lexicographically smallest instructions that will lead him to destination. k is 1-indexed.
#Given an integer array destination and an integer k, return the kth lexicographically smallest instructions that will take Bob to destination.


class Solution(object):
    def kthSmallestPath(self, destination, k):
        """
        :type destination: List[int]
        :type k: int
        :rtype: str
        """
        @lru_cache(None)
        def dp(i, j):
            if i == 0:
                return 'V' * j
            if j == 0:
                return 'H' * i
            return 'H' + dp(i-1, j) if k <= comb(i+j-1, j) else 'V' + dp(i, j-1)
        return dp(destination[0], destination[1])
        
        
        
    