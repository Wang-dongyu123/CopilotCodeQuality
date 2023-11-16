/**https://leetcode.com/problems/max-area-of-island/ */
//You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//The area of an island is the number of cells with a value 1 in the island.
//Return the maximum area of an island in grid. If there is no island, return 0.
// 
//Example 1:
//Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//Output: 6
//Explanation: The answer is not 11, because the island must be connected 4-directionally.
//Example 2:
//Input: grid = [[0,0,0,0,0,0,0,0]]
//Output: 0
// 
//Constraints:
//	m == grid.length
//	n == grid[i].length
//	1 <= m, n <= 50
//	grid[i][j] is either 0 or 1.
/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxAreaOfIsland = function(grid) {
    let maxArea = 0;
    let currentArea = 0;
    const isIsland = (i, j) => {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        return grid[i][j] === 1;
    }
    const visitIsland = (i, j) => {
        if (isIsland(i, j)) {
            grid[i][j] = 0;
            currentArea++;
            visitIsland(i + 1, j);
            visitIsland(i - 1, j);
            visitIsland(i, j + 1);
            visitIsland(i, j - 1);
        }
    }
    for (let i = 0; i < grid.length; i++) {
        for (let j =0; j < grid[0].length; j++) {
            if (grid[i][j] === 1) {
                currentArea = 0;
                visitIsland(i, j);
                maxArea = Math.max(maxArea, currentArea);
            }
        }
    }
    return maxArea;
};