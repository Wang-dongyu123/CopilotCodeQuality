/**https://leetcode.com/problems/cherry-pickup-ii/ */
//You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.
//You have two robots that can collect cherries for you:
//Robot #1 is located at the top-left corner (0, 0), and
//Robot #2 is located at the top-right corner (0, cols - 1).
//Return the maximum number of cherries collection using both robots by following the rules below:
//From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
//When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
//When both robots stay in the same cell, only one takes the cherries.
//Both robots cannot move outside of the grid at any moment.
//Both robots should reach the bottom row in grid.


/**
 * @param {number[][]} grid
 * @return {number}
 */
var cherryPickup = function(grid) {
    let m = grid.length;
    let n = grid[0].length;
    let dp = new Array(m);
    for(let i = 0; i < dp.length; i++){
        dp[i] = new Array(n);
        for(let j = 0; j < dp[i].length; j++){
            dp[i][j] = new Array(n).fill(-1);
        }
    }
    return Math.max(0, dfs(grid, 0, 0, n - 1, dp));
    
};
function dfs(grid, row, col1, col2, dp){
    if(row == grid.length){
        return 0;
    }
    if(dp[row][col1][col2] != -1){
        return dp[row][col1][col2];
    }
    let ans = 0;
    for(let i = -1; i <= 1; i++){
        for(let j = -1; j <= 1; j++){
            let newCol1 = col1 + i;
            let newCol2 = col2 + j;
            if(newCol1 >= 0 && newCol1 < grid[0].length && newCol2 >= 0 && newCol2 < grid[0].length){
                ans = Math.max(ans, dfs(grid, row + 1, newCol1, newCol2, dp));
            }
        }
    }
    ans += col1 == col2 ? grid[row][col1] : grid[row][col1] + grid[row][col2];
    return dp[row][col1][col2] = ans;
}
    