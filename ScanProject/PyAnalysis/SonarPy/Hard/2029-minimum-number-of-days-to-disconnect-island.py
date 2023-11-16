#https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/
#You are given an m x n binary grid grid where 1 represents land and 0 represents water. An island is a maximal 4-directionally (horizontal or vertical) connected group of 1's.
#The grid is said to be connected if we have exactly one island, otherwise is said disconnected.
#In one day, we are allowed to change any single land cell (1) into a water cell (0).
#Return the minimum number of days to disconnect the grid.


class Solution(object):
    def minDays(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m = len(grid)
        n = len(grid[0])
        
        def dfs(i, j):
            if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] == 0:
                return
            grid[i][j] = 0
            dfs(i+1, j)
            dfs(i-1, j)
            dfs(i, j+1)
            dfs(i, j-1)
        
        
    