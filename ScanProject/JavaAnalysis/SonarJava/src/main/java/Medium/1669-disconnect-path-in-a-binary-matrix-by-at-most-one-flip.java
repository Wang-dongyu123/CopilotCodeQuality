package main.java.Medium;

/**https://leetcode.com/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip/ */
//You are given a 0-indexed m x n binary matrix grid. You can move from a cell (row, col) to any of the cells (row + 1, col) or (row, col + 1) that has the value 1. The matrix is disconnected if there is no path from (0, 0) to (m - 1, n - 1).
//You can flip the value of at most one (possibly none) cell. You cannot flip the cells (0, 0) and (m - 1, n - 1).
//Return true if it is possible to make the matrix disconnect or false otherwise.
//Note that flipping a cell changes its value from 0 to 1 or from 1 to 0.


class DisconnectPathInABinaryMatrixByAtMostOneFlip {
    public boolean isPossibleToCutPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        return dfs(grid, visited, 0, 0);
        
    }


    private boolean dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }
        
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return false;
        }
        
        visited[i][j] = true;
        
        if (dfs(grid, visited, i + 1, j) || dfs(grid, visited, i, j + 1)) {
            return true;
        }
        
        return false;
    }

   
}

    