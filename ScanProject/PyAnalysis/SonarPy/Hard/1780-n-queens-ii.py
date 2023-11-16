#https://leetcode.com/problems/n-queens-ii/
#The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
#Given an integer n, return the number of distinct solutions to the n-queens puzzle.


class Solution(object):
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: int
        """
        self.n = n
        self.ans = 0
        self.solve(0,[])
        return self.ans
    def solve(self, row, path):
        if row == self.n:
            self.ans += 1
            return
        for col in range(self.n):
            if self.check(row,col,path):
                self.solve(row + 1, path + [col])
        
    