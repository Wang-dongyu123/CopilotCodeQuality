/**https://leetcode.com/problems/coloring-a-border/ */
//You are given an m x n integer matrix grid, and three integers row, col, and color. Each value in the grid represents the color of the grid square at that location.
//Two squares belong to the same connected component if they have the same color and are next to each other in any of the 4 directions.
//The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).
//You should color the border of the connected component that contains the square grid[row][col] with color.
//Return the final grid.


/**
 * @param {number[][]} grid
 * @param {number} row
 * @param {number} col
 * @param {number} color
 * @return {number[][]}
 */
var colorBorder = function(grid, row, col, color) {
    let n = grid.length;
    let m = grid[0].length;
    let visited = new Array(n).fill(0).map(() => new Array(m).fill(0));
    let result = new Array(n).fill(0).map(() => new Array(m).fill(0));
    let target = grid[row][col];
    dfs(grid, row, col, color, visited, result, target);
    return result;
    
    
    
};
function dfs(grid, x, y, color, visited, result, target){
    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
        return;
    }
    if(grid[x][y] != target){
        return;
    }
    if(visited[x][y] == 1){
        return;
    }
    visited[x][y] = 1;
    if(x == 0 || x == grid.length - 1 || y == 0 || y == grid[0].length - 1){
        result[x][y] = color;
    }else if(grid[x - 1][y] != target || grid[x + 1][y] != target || grid[x][y - 1] != target || grid[x][y + 1] != target){
        result[x][y] = color;
    }else{
        result[x][y] = target;
    }
    dfs(grid, x + 1, y, color, visited, result, target);
    dfs(grid, x - 1, y, color, visited, result, target);
    dfs(grid, x, y + 1, color, visited, result, target);
    dfs(grid, x, y - 1, color, visited, result, target);
}

    