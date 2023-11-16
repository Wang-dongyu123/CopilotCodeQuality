/**https://leetcode.com/problems/n-queens/ */
//The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.


/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    let res = [];
    let board = new Array(n);
    for(let i = 0; i < n; i++){
        board[i] = new Array(n).fill('.');
    }
    backtrack(board, 0, res);
    return res;
    
    
};

function backtrack(board, row, res){
    if(row == board.length){
        let copy = [];
        for(let i = 0; i < board.length; i++){
            copy.push(board[i].join(''));
        }
        res.push(copy);
        return;
    }
    for(let i = 0; i < board.length; i++){
        if(!isValid(board, row, i)){
            continue;
        }
        board[row][i] = 'Q';
        backtrack(board, row + 1, res);
        board[row][i] = '.';
    }
}
function isValid(board, row, col){
    for(let i = 0; i < row; i++){
        if(board[i][col] == 'Q'){
            return false;
        }
    }
    for(let i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
        if(board[i][j] == 'Q'){
            return false;
        }
    }
    for(let i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++){
        if(board[i][j] == 'Q'){
            return false;
        }
    }
    return true;
}