package main.java.Medium;

/**https://leetcode.com/problems/detect-cycles-in-2d-grid/ */
//Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same value in grid.
//A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same value of the current cell.
//Also, you cannot move to the cell that you visited in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.
//Return true if any cycle of the same value exists in grid, otherwise, return false.


class DetectCyclesIn2DGrid {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == 0){
                    if(dfs(grid, i, j, visited, directions, -1, -1)){
                        return true;
                    }
                }
            }
        }
        return false;
        
        
    }
    public boolean dfs(char[][] grid, int i, int j, int[][] visited, int[][] directions, int prevI, int prevJ){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == 2 || grid[i][j] != grid[prevI][prevJ]){
            return false;
        }
        if(visited[i][j] == 1){
            return true;
        }
        visited[i][j] = 1;
        for(int[] direction : directions){
            int x = i + direction[0];
            int y = j + direction[1];
            if(x == prevI && y == prevJ){
                continue;
            }
            if(dfs(grid, x, y, visited, directions, i, j)){
                return true;
            }
        }
        visited[i][j] = 2;
        return false;
    }
}
     
    