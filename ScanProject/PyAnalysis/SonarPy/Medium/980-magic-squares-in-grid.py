#https://leetcode.com/problems/magic-squares-in-grid/
#A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
#Given a row x col grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).


class Solution(object):
    def numMagicSquaresInside(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """       
        def isMagicSquare(grid, i, j):
            s = set()
            for a in range(i, i + 3):
                for b in range(j, j + 3):
                    if grid[a][b] > 9 or grid[a][b] < 1:
                        return False
                    if grid[a][b] in s:
                        return False
                    s.add(grid[a][b])
            for a in range(3):
                if sum(grid[i+a][j:j+3]) != 15:
                    return False
                if sum(grid[i:i+3][a][j]) != 15:
                    return False
            if grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2] != 15:
                return False
            if grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j] != 15:
                return False
            return True
        if len(grid) < 3 or len(grid[0]) < 3:
            return 0
        ans = 0
        for i in range(len(grid) - 2):
            for j in range(len(grid[0]) - 2):
                if isMagicSquare(grid, i, j):
                    ans += 1
        return ans
        
        

    