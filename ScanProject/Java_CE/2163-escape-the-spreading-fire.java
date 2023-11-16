package main.java.Hard;

/**https://leetcode.com/problems/escape-the-spreading-fire/ */
//You are given a 0-indexed 2D integer array grid of size m x n which represents a field. Each cell has one of three values:
//0 represents grass,
//1 represents fire,
//2 represents a wall that you and fire cannot pass through.
//You are situated in the top-left cell, (0, 0), and you want to travel to the safehouse at the bottom-right cell, (m - 1, n - 1). Every minute, you may move to an adjacent grass cell. After your move, every fire cell will spread to all adjacent cells that are not walls.
//Return the maximum number of minutes that you can stay in your initial position before moving while still safely reaching the safehouse. If this is impossible, return -1. If you can always reach the safehouse regardless of the minutes stayed, return 109.
//Note that even if the fire spreads to the safehouse immediately after you have reached it, it will be counted as safely reaching the safehouse.
//A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).


class EscapeTheSpreadingFire {
    public int maximumMinutes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited = new boolean[m][n];
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                if(grid[x][y] == 2){
                    continue;
                }
                if(x == m-1 && y == n-1){
                    flag = true;
                }
                for(int[] d: dir){
                    int newX = x + d[0];
                    int newY = y + d[1];
                    if(newX>=0 && newX<m && newY>=0 && newY<n && grid[newX][newY] != 2 && !visited[newX][newY]){
                        q.offer(new int[]{newX,newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            if(flag){
                return ans+1;
            }
            ans++;
        }
        return -1;
        
        
    }
}
     
    