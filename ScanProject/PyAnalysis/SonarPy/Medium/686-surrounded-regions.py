#https://leetcode.com/problems/surrounded-regions/
#Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
#A region is captured by flipping all 'O's into 'X's in that surrounded region.


class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        def dfs(board, i, j):
            if i < 0 or j < 0 or i >= m or j >= n or board[i][j] != 'O':
                return
            board[i][j] = '1'
            dfs(board, i+1, j)
            dfs(board, i-1, j)
            dfs(board, i, j+1)
            dfs(board, i, j-1)
            
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                if (i==0 or i==m-1 or j==0 or j==n-1) and board[i][j] == 'O':
                    dfs(board,i,j)
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                if board[i][j] == '1':
                    board[i][j] = 'O'
        return board

    