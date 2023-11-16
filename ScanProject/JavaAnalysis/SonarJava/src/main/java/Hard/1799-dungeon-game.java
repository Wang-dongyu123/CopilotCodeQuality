package main.java.Hard;

import java.util.Arrays;

/**https://leetcode.com/problems/dungeon-game/ */
//The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon to rescue the princess.
//The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
//Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).
//To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
//Return the knight's minimum initial health so that he can rescue the princess.
//Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.


class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(min - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
        
    }
}
     
    