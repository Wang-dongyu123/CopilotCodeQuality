package main.java.Medium;

/**https://leetcode.com/problems/spiral-matrix-iii/ */
//You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.
//You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.
//Return an array of coordinates representing the positions of the grid in the order you visited them.


class SpiralMatrixIii {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int k = 0;
        int len = 1;
        int i = rStart;
        int j = cStart;
        res[k++] = new int[]{i, j};
        while(k < rows * cols){
            for(int l = 0; l < 2; l++){
                for(int m = 0; m < len; m++){
                    i += dirs[k % 4][0];
                    j += dirs[k % 4][1];
                    if(i >= 0 && i < rows && j >= 0 && j < cols){
                        res[k++] = new int[]{i, j};
                    }
                }
                len++;
            }
        }
        return res;
        
    }
}

    