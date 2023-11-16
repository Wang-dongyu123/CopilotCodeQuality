package main.java.Medium;

/**https://leetcode.com/problems/coloring-a-border/ */
//You are given an m x n integer matrix grid, and three integers row, col, and color. Each value in the grid represents the color of the grid square at that location.
//Two squares belong to the same connected component if they have the same color and are next to each other in any of the 4 directions.
//The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).
//You should color the border of the connected component that contains the square grid[row][col] with color.
//Return the final grid.


class ColoringABorder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];
        dfs(grid, row, col, grid[row][col], color, visited, dirs);
        return grid;
        
        
    }
    public void dfs(int[][] grid, int i, int j, int oldColor, int newColor, boolean[][] visited, int[][] dirs){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        if(grid[i][j] != oldColor){
            return;
        }
        if(visited[i][j]){
            return;
        }
        visited[i][j] = true;
        boolean isBorder = false;
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
                isBorder = true;
                continue;
            }
            if(grid[x][y] != oldColor){
                isBorder = true;
                continue;
            }
            if(visited[x][y]){
                continue;
            }
            dfs(grid, x, y, oldColor, newColor, visited, dirs);
        }
        if(isBorder){
            grid[i][j] = newColor;
        }
    }
}

    