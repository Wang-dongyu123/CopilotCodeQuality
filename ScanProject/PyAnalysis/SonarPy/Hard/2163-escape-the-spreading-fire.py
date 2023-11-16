#https://leetcode.com/problems/escape-the-spreading-fire/
#You are given a 0-indexed 2D integer array grid of size m x n which represents a field. Each cell has one of three values:
#0 represents grass,
#1 represents fire,
#2 represents a wall that you and fire cannot pass through.
#You are situated in the top-left cell, (0, 0), and you want to travel to the safehouse at the bottom-right cell, (m - 1, n - 1). Every minute, you may move to an adjacent grass cell. After your move, every fire cell will spread to all adjacent cells that are not walls.
#Return the maximum number of minutes that you can stay in your initial position before moving while still safely reaching the safehouse. If this is impossible, return -1. If you can always reach the safehouse regardless of the minutes stayed, return 109.
#Note that even if the fire spreads to the safehouse immediately after you have reached it, it will be counted as safely reaching the safehouse.
#A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).


class Solution(object):
    def maximumMinutes(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m = len(grid)
        n = len(grid[0])
        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        def bfs():
            q = []
            for i in range(m):
                for j in range(n):
                    if grid[i][j] == 2:
                        q.append((i, j))
            res = 0
            while q:
                newq = []
                for i, j in q:
                    for di, dj in directions:
                        x = i + di
                        y = j + dj
                        if 0 <= x < m and 0 <= y < n and grid[x][y] == 0:
                            grid[x][y] = 2
                            newq.append((x, y))
                q = newq
                res += 1
            return res
        res = bfs()
        if grid[0][0] == 1:
            return -1
        grid[0][0] = 2
        q = [(0, 0)]
        res = 0
        while q:
            newq = []
            for i, j in q:
                for di, dj in directions:
                    x = i + di
                    y = j + dj
                    if 0 <= x < m and 0 <= y < n and grid[x][y] == 0:
                        grid[x][y] = 2
                        newq.append((x, y))
            q = newq
            res += 1
        return res

        
        
    