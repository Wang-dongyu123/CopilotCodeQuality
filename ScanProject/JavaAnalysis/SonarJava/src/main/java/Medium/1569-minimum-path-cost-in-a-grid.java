package main.java.Medium;

/**https://leetcode.com/problems/minimum-path-cost-in-a-grid/ */
//You are given a 0-indexed m x n integer matrix grid consisting of distinct integers from 0 to m * n - 1. You can move in this matrix from a cell to any other cell in the next row. That is, if you are in cell (x, y) such that x < m - 1, you can move to any of the cells (x + 1, 0), (x + 1, 1), ..., (x + 1, n - 1). Note that it is not possible to move from cells in the last row.
//Each possible move has a cost given by a 0-indexed 2D array moveCost of size (m * n) x n, where moveCost[i][j] is the cost of moving from a cell with value i to a cell in column j of the next row. The cost of moving from cells in the last row of grid can be ignored.
//The cost of a path in grid is the sum of all values of cells visited plus the sum of costs of all the moves made. Return the minimum cost of a path that starts from any cell in the first row and ends at any cell in the last row.


class MinimumPathCostInAGrid {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < n; i++){
            dp[0][i] = grid[0][i];
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + moveCost[grid[i-1][k]][k] + grid[i][j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min, dp[m-1][i]);
        }
        return min;
        
    }
}
     
    