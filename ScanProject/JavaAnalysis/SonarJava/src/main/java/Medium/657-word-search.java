package main.java.Medium;

/**https://leetcode.com/problems/word-search/ */
//Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.


class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, word, 0, i, j, visited)){
                    return true;
                }
            }
        }
        return false;
        
    }
    private boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited){
        if(index == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]){
            return false;
        }
        visited[i][j] = true;
        boolean res = dfs(board, word, index + 1, i + 1, j, visited) || 
            dfs(board, word, index + 1, i - 1, j, visited) ||
            dfs(board, word, index + 1, i, j + 1, visited) ||
            dfs(board, word, index + 1, i, j - 1, visited);
        visited[i][j] = false;
        return res;
    }
}

    