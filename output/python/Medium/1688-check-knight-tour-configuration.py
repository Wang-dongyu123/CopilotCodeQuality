#https://leetcode.com/problems/check-knight-tour-configuration/
#There is a knight on an n x n chessboard. In a valid configuration, the knight starts at the top-left cell of the board and visits every cell on the board exactly once.
#You are given an n x n integer matrix grid consisting of distinct integers from the range [0, n * n - 1] where grid[row][col] indicates that the cell (row, col) is the grid[row][col]th cell that the knight visited. The moves are 0-indexed.
#Return true if grid represents a valid configuration of the knight's movements or false otherwise.
#Note that a valid knight move consists of moving two squares vertically and one square horizontally, or two squares horizontally and one square vertically. The figure below illustrates all the possible eight moves of a knight from some cell.
# 
#Example 1:
#Input: grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]
#Output: true
#Explanation: The above diagram represents the grid. It can be shown that it is a valid configuration.
#Example 2:
#Input: grid = [[0,3,6],[5,8,1],[2,7,4]]
#Output: false
#Explanation: The above diagram represents the grid. The 8th move of the knight is not valid considering its position after the 7th move.
# 
#Constraints:
#	n == grid.length == grid[i].length
#	3 <= n <= 7
#	0 <= grid[row][col] < n * n
#	All integers in grid are unique.
class Solution(object):
    def checkValidGrid(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: bool
        """
        def dfs(row, col, visited, n):
            if row < 0 or row >= n or col < 0 or col >= n or visited[row][col] == True:
                return False
            visited[row][col] = True
            for i in range(len(dx)):
                if dfs(row + dx[i], col + dy[i], visited, n) == True:
                    return True
            visited[row][col] = False
            return True
        n = len(grid)
        dx = [2, 1, -1, -2, -2, -1, 1, 2]
        dy = [1, 2, 2, 1, -1, -2, -2, -1]
        visited = [[False] * n for i in range(n)]
        for i in range(n):
            for j in range(n):
                if dfs(i, j, visited, n) == False:
                    return False
        return True
