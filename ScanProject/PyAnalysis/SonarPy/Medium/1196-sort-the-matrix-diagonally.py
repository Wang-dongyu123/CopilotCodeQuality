#https://leetcode.com/problems/sort-the-matrix-diagonally/
#A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].
#Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.


class Solution(object):
    def diagonalSort(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        def sort(mat, i, j):
            diag = []
            while i < m and j < n:
                diag.append(mat[i][j])
                i += 1
                j += 1
            diag.sort()
            while i > 0 and j > 0:
                i -= 1
                j -= 1
                mat[i][j] = diag.pop()
        m, n = len(mat), len(mat[0])
        for i in range(m):
            self.sort(mat, i, 0)
        for j in range(n):
            self.sort(mat, 0, j)
        return mat
        

    