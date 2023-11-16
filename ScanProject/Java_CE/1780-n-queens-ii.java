package main.java.Hard;

/**https://leetcode.com/problems/n-queens-ii/ */
//The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//Given an integer n, return the number of distinct solutions to the n-queens puzzle.


class NQueensIi {
    public int totalNQueens(int n) {
         char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        return solve(board,0);
    }
    private int solve(char[][] board,int col){
        if(col==board.length){
            return 1;
        }
        int count=0;
        for(int i=0;i<board.length;i++){
            if(isValid(board,i,col)){
                board[i][col]='Q';
                count+=solve(board,col+1);
                board[i][col]='.';
            }
        }
        return count;
    }
    private boolean isValid(char[][] board,int row,int col){
        for(int i=0;i<board.length;i++){
            if(board[i][col]!='.'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]!='.'){
                return false;
            }
        }
        for(int i=row+1,j=col-1;i<board.length && j>=0;i++,j--){
            if(board[i][j]!='.'){
                return false;
            }
        }
        return true;
        
}
}
     
    