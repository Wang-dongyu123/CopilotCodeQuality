package main.java.Hard;

/**https://leetcode.com/problems/zuma-game/ */
//You are playing a variation of the game Zuma.
//In this variation of Zuma, there is a single row of colored balls on a board, where each ball can be colored red 'R', yellow 'Y', blue 'B', green 'G', or white 'W'. You also have several colored balls in your hand.
//Your goal is to clear all of the balls from the board. On each turn:
//Pick any ball from your hand and insert it in between two balls in the row or on either end of the row.
//If there is a group of three or more consecutive balls of the same color, remove the group of balls from the board.
//If this removal causes more groups of three or more of the same color to form, then continue removing each group until there are none left.
//If there are no more balls on the board, then you win the game.
//Repeat this process until you either win or do not have any more balls in your hand.
//Given a string board, representing the row of balls on the board, and a string hand, representing the balls in your hand, return the minimum number of balls you have to insert to clear all the balls from the board. If you cannot clear all the balls from the board using the balls in your hand, return -1.


class ZumaGame {
    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for (char c : hand.toCharArray()) {
            handCount[c - 'A']++;
        }
        int ans = dfs(board + "#", handCount);
        return ans == 6 ? -1 : ans;
        
    }
    public int dfs(String s, int[] count) {
        s = removeConsecutive(s);
        if (s.equals("#")) {
            return 0;
        }
        int res = 6;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (s.charAt(j) == s.charAt(i)) {
                continue;
            }
            int need = 3 - (j - i);
            if (count[s.charAt(i) - 'A'] >= need) {
                count[s.charAt(i) - 'A'] -= need;
                res = Math.min(res, need + dfs(s.substring(0, i) + s.substring(j), count));
                count[s.charAt(i) - 'A'] += need;
            }
            i = j;
        }
        return res;
    }
    public String removeConsecutive(String s) {
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (s.charAt(j) == s.charAt(i)) {
                continue;
            }
            if (j - i >= 3) {
                return removeConsecutive(s.substring(0, i) + s.substring(j));
            } else {
                i = j;
            }
        }
        return s;
    }
}
     
    