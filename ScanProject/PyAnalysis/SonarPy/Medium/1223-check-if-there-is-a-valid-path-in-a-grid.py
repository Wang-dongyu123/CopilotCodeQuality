#https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
#You are given an m x n grid. Each cell of grid represents a street. The street of grid[i][j] can be:
#1 which means a street connecting the left cell and the right cell.
#2 which means a street connecting the upper cell and the lower cell.
#3 which means a street connecting the left cell and the lower cell.
#4 which means a street connecting the right cell and the lower cell.
#5 which means a street connecting the left cell and the upper cell.
#6 which means a street connecting the right cell and the upper cell.
#You will initially start at the street of the upper-left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1). The path should only follow the streets.
#Notice that you are not allowed to change any street.
#Return true if there is a valid path in the grid or false otherwise.


class Solution(object):
    def hasValidPath(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: bool
        """       
        res = False
        return res