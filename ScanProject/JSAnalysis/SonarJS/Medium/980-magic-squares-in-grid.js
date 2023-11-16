/**https://leetcode.com/problems/magic-squares-in-grid/ */
//A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
//Given a row x col grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).


/**
 * @param {number[][]} grid
 * @return {number}
 */
var numMagicSquaresInside = function(grid) {
    let count = 0;
    for(let i = 0; i < grid.length - 2; i++){
        for(let j = 0; j < grid[0].length - 2; j++){
            if(grid[i + 1][j + 1] != 5){
                continue;
            }
            if(isMagic(grid, i, j)){
                count++;
            }
        }
    }
    return count;
    
    
    
};
function isMagic(grid, x, y){
    let count = new Array(10).fill(0);
    for(let i = x; i < x + 3; i++){
        for(let j = y; j < y + 3; j++){
            count[grid[i][j]]++;
        }
    }
    for(let i = 1; i <= 9; i++){
        if(count[i] != 1){
            return false;
        }
    }
    let sum = grid[x][y] + grid[x + 1][y] + grid[x + 2][y];
    for(let j = y; j < y + 3; j++){
        let temp = grid[x][j] + grid[x + 1][j] + grid[x + 2][j];
        if(temp != sum){
            return false;
        }
    }
    for(let i = x; i < x + 3; i++){
        let temp = grid[i][y] + grid[i][y + 1] + grid[i][y + 2];
        if(temp != sum){
            return false;
        }
    }
    if(grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2] != sum){
        return false;
    }
    if(grid[x + 2][y] + grid[x + 1][y + 1] + grid[x][y + 2] != sum){
        return false;
    }
    return true;
}

    