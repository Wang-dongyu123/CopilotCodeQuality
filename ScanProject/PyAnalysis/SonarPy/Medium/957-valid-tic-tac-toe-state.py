#https://leetcode.com/problems/valid-tic-tac-toe-state/
#Given a Tic-Tac-Toe board as a string array board, return true if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.
#The board is a 3 x 3 array that consists of characters ' ', 'X', and 'O'. The ' ' character represents an empty square.
#Here are the rules of Tic-Tac-Toe:
#Players take turns placing characters into empty squares ' '.
#The first player always places 'X' characters, while the second player always places 'O' characters.
#'X' and 'O' characters are always placed into empty squares, never filled ones.
#The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
#The game also ends if all squares are non-empty.
#No more moves can be played if the game is over.


class Solution(object):
    def validTicTacToe(self, board):
        """
        :type board: List[str]
        :rtype: bool
        """
        def win(board, c):
            for i in range(3):
                if all(board[i][j] == c for j in range(3)):
                    return True
                if all(board[j][i] == c for j in range(3)):
                    return True
            if all(board[i][i] == c for i in range(3)):
                return True
            if all(board[i][2-i] == c for i in range(3)):
                return True
            return False
        
        x = sum(row.count('X') for row in board)
        o = sum(row.count('O') for row in board)
        if x < o or x > o + 1:
            return False
        if win(board, 'O') and x != o:
            return False
        if win(board, 'X') and x != o + 1:
            return False
        return True
        

    