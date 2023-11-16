#https://leetcode.com/problems/word-search/
#Given an m x n grid of characters board and a string word, return true if word exists in the grid.
#The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.


class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        def dfs(board,word,i,j,k):
            if k == len(word):
                return True
            if i < 0 or j < 0 or i >= len(board) or j >= len(board[0]) or board[i][j] != word[k]:
                return False
            board[i][j] = '#'
            res = dfs(board,word,i+1,j,k+1) or dfs(board,word,i-1,j,k+1) or dfs(board,word,i,j+1,k+1) or dfs(board,word,i,j-1,k+1)
            board[i][j] = word[k]
            return res
        

    