/**https://leetcode.com/problems/last-day-where-you-can-still-cross/ */
//There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.
//Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).
//You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).
//Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.


/**
 * @param {number} row
 * @param {number} col
 * @param {number[][]} cells
 * @return {number}
 */
var latestDayToCross = function(row, col, cells) {
    let result = 0;
    let grid = new Array(row);
    for (let i = 0; i < row; i++) {
        grid[i] = new Array(col).fill(0);
    }
    for (let i = 0; i < cells.length; i++) {
        let [r, c] = cells[i];
        grid[r - 1][c - 1] = 1;
        if (isConnected(grid)) {
            result = i + 1;
        }
    }
    return result;
    
    
    
};
function isConnected(grid) {
    let queue = [];
    let visited = new Array(grid.length);
    for (let i = 0; i < visited.length; i++) {
        visited[i] = new Array(grid[0].length).fill(false);
    }
    for (let i = 0; i < grid[0].length; i++) {
        if (grid[0][i] == 0) {
            queue.push([0, i]);
            visited[0][i] = true;
        }
    }
    let dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]];
    while (queue.length > 0) {
        let [r, c] = queue.shift();
        if (r == grid.length - 1) {
            return true;
        }
        for (let [dr, dc] of dirs) {
            let nr = r + dr;
            let nc = c + dc;
            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] == 1 || visited[nr][nc]) {
                continue;
            }
            queue.push([nr, nc]);
            visited[nr][nc] = true;
        }
    }
    return false;
}