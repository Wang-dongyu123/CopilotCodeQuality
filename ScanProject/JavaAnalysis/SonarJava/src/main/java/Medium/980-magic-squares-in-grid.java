package main.java.Medium;

/**https://leetcode.com/problems/magic-squares-in-grid/ */
//A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
//Given a row x col grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).


class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length - 2; i++){
            for(int j = 0; j < grid[0].length - 2; j++){
                if(grid[i + 1][j + 1] != 5){
                    continue;
                }
                if(isMagic(grid, i, j)){
                    res++;
                }
            }
        }
        return res;
        
        
    }
    public boolean isMagic(int[][] grid, int i, int j){
        int[] count = new int[16];
        for(int x = i; x < i + 3; x++){
            for(int y = j; y < j + 3; y++){
                count[grid[x][y]]++;
            }
        }
        for(int k = 1; k <= 9; k++){
            if(count[k] != 1){
                return false;
            }
        }
        return grid[i][j] + grid[i][j + 1] + grid[i][j + 2] == 15 &&
            grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] == 15 &&
            grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] == 15 &&
            grid[i][j] + grid[i + 1][j] + grid[i + 2][j] == 15 &&
            grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] == 15 &&
            grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] == 15 &&
            grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] == 15 &&
            grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2] == 15;
    }
}

    