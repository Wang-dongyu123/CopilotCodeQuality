#https://leetcode.com/problems/dungeon-game/
#The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon to rescue the princess.
#The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
#Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).
#To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
#Return the knight's minimum initial health so that he can rescue the princess.
#Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.


class Solution(object):
    def calculateMinimumHP(self, dungeon):
        """
        :type dungeon: List[List[int]]
        :rtype: int
        """
        # initialize the number of rows
        rows = len(dungeon)
        # initialize the number of columns
        cols = len(dungeon[0])
        # initialize the dp array
        dp = [[0 for _ in range(cols)] for _ in range(rows)]
        # initialize the last row and column
        dp[rows - 1][cols - 1] = max(1, 1 - dungeon[rows - 1][cols - 1])
        # iterate through the rows
        for row in range(rows - 2, -1, -1):
            # set the dp array to the minimum of the dp array plus the dungeon array or 1
            dp[row][cols - 1] = max(1, dp[row + 1][cols - 1] - dungeon[row][cols - 1])
        # iterate through the columns
        for col in range(cols - 2, -1, -1):
            # set the dp array to the minimum of the dp array plus the dungeon array or 1
            dp[rows - 1][col] = max(1, dp[rows - 1][col + 1] - dungeon[rows - 1][col])
        # iterate through the rows
        for row in range(rows - 2, -1, -1):
            # iterate through the columns
            for col in range(cols - 2, -1, -1):
                # set the dp array to the minimum of the dp array plus the dungeon array or 1
                dp[row][col] = max(1, min(dp[row + 1][col], dp[row][col + 1]) - dungeon[row][col])
        # return the dp array at index 0, 0
        return dp[0][0]
        
        
    