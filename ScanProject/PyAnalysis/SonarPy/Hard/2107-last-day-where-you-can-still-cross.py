#https://leetcode.com/problems/last-day-where-you-can-still-cross/
#There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.
#Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).
#You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).
#Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.


class Solution(object):
    def latestDayToCross(self, row, col, cells):
        """
        :type row: int
        :type col: int
        :type cells: List[List[int]]
        :rtype: int
        """
        def bfs(day):
            q = collections.deque()
            visited = set()
            for i in range(col):
                if grid[0][i] == 0:
                    q.append((0, i))
                    visited.add((0, i))
            while q:
                r, c = q.popleft()
                if r == row - 1:
                    return True
                for nr, nc in [(r+1, c), (r-1, c), (r, c+1), (r, c-1)]:
                    if 0 <= nr < row and 0 <= nc < col and (nr, nc) not in visited and grid[nr][nc] <= day:
                        q.append((nr, nc))
                        visited.add((nr, nc))
            return False
        
        grid = [[0] * col for _ in range(row)]
        for i, (r, c) in enumerate(cells):
            grid[r-1][c-1] = i + 1
        l, r = 0, len(cells)
        while l < r:
            mid = (l + r) // 2
            if bfs(mid + 1):
                l = mid + 1
            else:
                r = mid
        return l
        
    