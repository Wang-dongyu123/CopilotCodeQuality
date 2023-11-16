package main.java.Medium;

/**https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/ */
//You are given an m x n grid. Each cell of grid represents a street. The street of grid[i][j] can be:
//1 which means a street connecting the left cell and the right cell.
//2 which means a street connecting the upper cell and the lower cell.
//3 which means a street connecting the left cell and the lower cell.
//4 which means a street connecting the right cell and the lower cell.
//5 which means a street connecting the left cell and the upper cell.
//6 which means a street connecting the right cell and the upper cell.
//You will initially start at the street of the upper-left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1). The path should only follow the streets.
//Notice that you are not allowed to change any street.
//Return true if there is a valid path in the grid or false otherwise.


class CheckIfThereIsAValidPathInAGrid {
    public boolean hasValidPath(int[][] grid) {
        int[][][] directions = new int[][][]{{{0, 1}, {0, -1}}, {{1, 0}, {-1, 0}}, {{0, 1}, {1, 0}}, {{0, -1}, {1, 0}}, {{0, 1}, {-1, 0}}, {{0, -1}, {-1, 0}}};
        int[][] visited = new int[grid.length][grid[0].length];
        return dfs(grid, 0, 0, visited, directions);
        
    }
    public boolean dfs(int[][] grid, int i, int j, int[][] visited, int[][][] directions){
        if(i == grid.length - 1 && j == grid[0].length - 1){
            return true;
        }
        visited[i][j] = 1;
        for(int[] direction : directions[grid[i][j] - 1]){
            int x = i + direction[0];
            int y = j + direction[1];
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] == 1){
                continue;
            }
            for(int[] reverse : directions[grid[x][y] - 1]){
                if(x + reverse[0] == i && y + reverse[1] == j){
                    if(dfs(grid, x, y, visited, directions)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

    