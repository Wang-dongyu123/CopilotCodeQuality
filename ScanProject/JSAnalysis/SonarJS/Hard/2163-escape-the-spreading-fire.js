/**https://leetcode.com/problems/escape-the-spreading-fire/ */
//You are given a 0-indexed 2D integer array grid of size m x n which represents a field. Each cell has one of three values:
//0 represents grass,
//1 represents fire,
//2 represents a wall that you and fire cannot pass through.
//You are situated in the top-left cell, (0, 0), and you want to travel to the safehouse at the bottom-right cell, (m - 1, n - 1). Every minute, you may move to an adjacent grass cell. After your move, every fire cell will spread to all adjacent cells that are not walls.
//Return the maximum number of minutes that you can stay in your initial position before moving while still safely reaching the safehouse. If this is impossible, return -1. If you can always reach the safehouse regardless of the minutes stayed, return 109.
//Note that even if the fire spreads to the safehouse immediately after you have reached it, it will be counted as safely reaching the safehouse.
//A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).


/**
 * @param {number[][]} grid
 * @return {number}
 */
var maximumMinutes = function(grid) {
    let m = grid.length;
    let n = grid[0].length;
    let ans = 0;
    let flag = true;
    while(flag){
        flag = false;
        for(let i = 0; i < m; i++){
            for(let j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    let temp = dfs(grid, i, j);
                    if(temp.length > 0){
                        flag = true;
                        ans++;
                    }
                }
            }
        }
    }
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            if(grid[i][j] == 1){
                return -1;
            }
        }
    }
    return ans;
    
    
    
};

function dfs(grid, r, c){
    let m = grid.length;
    let n = grid[0].length;
    let ans = [];
    let flag = true;
    for(let i = r - 1; i <= r + 1; i++){
        for(let j = c - 1; j <= c + 1; j++){
            if(i == r && j == c){
                continue;
            }
            if(i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 0){
                grid[i][j] = 1;
                ans.push([i, j]);
            }
        }
    }
    return ans;
}