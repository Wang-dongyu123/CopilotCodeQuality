#https://leetcode.com/problems/count-fertile-pyramids-in-a-land/
#A farmer has a rectangular grid of land with m rows and n columns that can be divided into unit cells. Each cell is either fertile (represented by a 1) or barren (represented by a 0). All cells outside the grid are considered barren.
#A pyramidal plot of land can be defined as a set of cells with the following criteria:
#The number of cells in the set has to be greater than 1 and all cells must be fertile.
#The apex of a pyramid is the topmost cell of the pyramid. The height of a pyramid is the number of rows it covers. Let (r, c) be the apex of the pyramid, and its height be h. Then, the plot comprises of cells (i, j) where r <= i <= r + h - 1 and c - (i - r) <= j <= c + (i - r).
#An inverse pyramidal plot of land can be defined as a set of cells with similar criteria:
#The number of cells in the set has to be greater than 1 and all cells must be fertile.
#The apex of an inverse pyramid is the bottommost cell of the inverse pyramid. The height of an inverse pyramid is the number of rows it covers. Let (r, c) be the apex of the pyramid, and its height be h. Then, the plot comprises of cells (i, j) where r - h + 1 <= i <= r and c - (r - i) <= j <= c + (r - i).
#Some examples of valid and invalid pyramidal (and inverse pyramidal) plots are shown below. Black cells indicate fertile cells.
#Given a 0-indexed m x n binary matrix grid representing the farmland, return the total number of pyramidal and inverse pyramidal plots that can be found in grid.


class Solution(object):
    def countPyramids(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m = len(grid)
        n = len(grid[0])
        
        def dfs(i, j, h, d):
            if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] == 0:
                return
            grid[i][j] = 0
            if d == 0:
                dfs(i+1, j, h+1, d)
                dfs(i+1, j+1, h+1, d)
            else:
                dfs(i-1, j, h+1, d)
                dfs(i-1, j-1, h+1, d)
            dfs(i, j-1, h+1, d)
            dfs(i, j+1, h+1, d)
        
        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    dfs(i, j, 1, 0)
                    dfs(i, j, 1, 1)
                    res += 1
        return res
        
        
    