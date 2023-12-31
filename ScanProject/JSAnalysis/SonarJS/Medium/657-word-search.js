/**https://leetcode.com/problems/word-search/ */
//Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.


/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function(board, word) {
    let m = board.length;
    let n = board[0].length;
    let visited = new Array(m);
    for(let i = 0; i < m; i++){
        visited[i] = new Array(n);
    }
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            if(dfs(board, word, i, j, 0, visited)){
                return true;
            }
        }
    }
    return false;
    
    
    
};
function dfs(board, word, i, j, index, visited){
    if(index == word.length){
        return true;
    }
    if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != word[index]){
        return false;
    }
    visited[i][j] = true;
    if(dfs(board, word, i - 1, j, index + 1, visited) || dfs(board, word, i + 1, j, index + 1, visited) || dfs(board, word, i, j - 1, index + 1, visited) || dfs(board, word, i, j + 1, index + 1, visited)){
        return true;
    }
    visited[i][j] = false;
    return false;
}

    