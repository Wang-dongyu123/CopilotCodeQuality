#https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/
#You are given an m x n integer matrix grid and an array queries of size k.
#Find an array answer of size k such that for each integer queres[i] you start in the top left cell of the matrix and repeat the following process:
#    If queries[i] is strictly greater than the value of the current cell that you are in, then you get one point if it is your first time visiting this cell, and you can move to any adjacent cell in all 4 directions: up, down, left, and right.
#    Otherwise, you do not get any points, and you end this process.
#After the process, answer[i] is the maximum number of points you can get. Note that for each query you are allowed to visit the same cell multiple times.
#Return the resulting array answer.


class Solution(object):
    def maxPoints(self, grid, queries):
        """
        :type grid: List[List[int]]
        :type queries: List[int]
        :rtype: List[int]
        """
        
        m = len(grid)
        n = len(grid[0])
        res = []
        for x, y, r in queries:
            ans = 0
            for i in range(x-r, x+r+1):
                for j in range(y-r, y+r+1):
                    if 0 <= i < m and 0 <= j < n:
                        ans += grid[i][j] <= r + max(abs(x - i), abs(y - j))
            res.append(ans)
        return res
        
    