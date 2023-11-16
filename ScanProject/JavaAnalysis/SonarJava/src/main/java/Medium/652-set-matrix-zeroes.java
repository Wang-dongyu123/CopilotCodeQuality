package main.java.Medium;

/**https://leetcode.com/problems/set-matrix-zeroes/ */
//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//You must do it in place.


class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    if(i == 0){
                        row = true;
                    }
                    if(j == 0){
                        col = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(row){
            for(int i = 0; i < n; i++){
                matrix[0][i] = 0;
            }
        }
        if(col){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        
    }
}

    