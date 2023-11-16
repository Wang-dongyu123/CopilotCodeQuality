package main.java.Medium;

/**https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/ */
//There is an m x n grid, where (0, 0) is the top-left cell and (m - 1, n - 1) is the bottom-right cell. You are given an integer array startPos where startPos = [startrow, startcol] indicates that initially, a robot is at the cell (startrow, startcol). You are also given an integer array homePos where homePos = [homerow, homecol] indicates that its home is at the cell (homerow, homecol).
//The robot needs to go to its home. It can move one cell in four directions: left, right, up, or down, and it can not move outside the boundary. Every move incurs some cost. You are further given two 0-indexed integer arrays: rowCosts of length m and colCosts of length n.
//If the robot moves up or down into a cell whose row is r, then this move costs rowCosts[r].
//If the robot moves left or right into a cell whose column is c, then this move costs colCosts[c].
//Return the minimum total cost for this robot to return home.


class MinimumCostHomecomingOfARobotInAGrid {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] visited = new int[rowCosts.length][colCosts.length];
        return dfs(startPos, homePos, rowCosts, colCosts, visited, directions);
        
        
    }
    public int dfs(int[] cur, int[] home, int[] rowCosts, int[] colCosts, int[][] visited, int[][] directions){
        int x = cur[0];
        int y = cur[1];
        if(x == home[0] && y == home[1]){
            return 0;
        }
        if(visited[x][y] != 0){
            return visited[x][y];
        }
        int res = Integer.MAX_VALUE;
        for(int[] dir : directions){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx < 0 || nx >= rowCosts.length || ny < 0 || ny >= colCosts.length){
                continue;
            }
            res = Math.min(res, dfs(new int[]{nx, ny}, home, rowCosts, colCosts, visited, directions) + (dir[0] == 0 ? colCosts[ny] : rowCosts[nx]));
        }
        visited[x][y] = res;
        return res;
    }
}
     
    