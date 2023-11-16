package main.java.Medium;

/**https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/ */
//You are given an m x n matrix board, representing the current state of a crossword puzzle. The crossword contains lowercase English letters (from solved words), ' ' to represent any empty cells, and '#' to represent any blocked cells.
//A word can be placed horizontally (left to right or right to left) or vertically (top to bottom or bottom to top) in the board if:
//	It does not occupy a cell containing the character '#'.
//	The cell each letter is placed in must either be ' ' (empty) or match the letter already on the board.
//	There must not be any empty cells ' ' or other lowercase letters directly left or right of the word if the word was placed horizontally.
//	There must not be any empty cells ' ' or other lowercase letters directly above or below the word if the word was placed vertically.
//Given a string word, return true if word can be placed in board, or false otherwise.
// 
//Example 1:
//Input: board = [["#", " ", "#"], [" ", " ", "#"], ["#", "c", " "]], word = "abc"
//Output: true
//Explanation: The word "abc" can be placed as shown above (top to bottom).
//Example 2:
//Input: board = [[" ", "#", "a"], [" ", "#", "c"], [" ", "#", "a"]], word = "ac"
//Output: false
//Explanation: It is impossible to place the word because there will always be a space/letter above or below it.
//Example 3:
//Input: board = [["#", " ", "#"], [" ", " ", "#"], ["#", " ", "c"]], word = "ca"
//Output: true
//Explanation: The word "ca" can be placed as shown above (right to left). 
// 
//Constraints:
//	m == board.length
//	n == board[i].length
//	1 <= m * n <= 2 * 105
//	board[i][j] will be ' ', '#', or a lowercase English letter.
//	1 <= word.length <= max(m, n)
//	word will contain only lowercase English letters.
class Solution252 {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[][] rotated = new char[n][m];
        for (int i = 0; i < n; i++) {
            int k = m - 1;
            for (int j = 0; j < m; j++) {
                rotated[i][j] = board[k][i];
                k--;
            }
        }
        return helper(board, word) || helper(rotated, word);
    }
    private boolean helper(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int len = word.length();
        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < n) {
                if (board[i][j] == '#') {
                    j++;
                    continue;
                }
                int start = j;
                while (j < n && board[i][j] != '#') {
                    j++;
                }
                if (j - start == len) {
                    boolean match = true;
                    for (int k = start; k < j; k++) {
                        if (board[i][k] != word.charAt(k - start) && board[i][k] != ' ') {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        return true;
                    }
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int i = 0;
            while (i < m) {
                if (board[i][j] == '#') {
                    i++;
                    continue;
                }
                int start = i;
                while (i < m && board[i][j] != '#') {
                    i++;
                }
                if (i - start == len) {
                    boolean match = true;
                    for (int k = start; k < i; k++) {
                        if (board[k][j] != word.charAt(k - start) && board[k][j] != ' ') {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}