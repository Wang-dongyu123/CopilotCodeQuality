package main.java.Medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**https://leetcode.com/problems/shortest-bridge/ */
//You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
//An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
//You may change 0's to 1's to connect the two islands to form one island.
//Return the smallest number of 0's you must flip to connect the two islands.
// 
//Example 1:
//Input: grid = [[0,1],[1,0]]
//Output: 1
//Example 2:
//Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
//Output: 2
//Example 3:
//Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//Output: 1
// 
//Constraints:
//	n == grid.length == grid[i].length
//	2 <= n <= 100
//	grid[i][j] is either 0 or 1.
//	There are exactly two islands in grid.
class Solution3 {
    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int steps = 0;
        boolean found = false;
        for(int i = 0; i < m && !found; i++){
            for(int j = 0; j < n && !found; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, q, visited);
                    found = true;
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                for(int[] dir : dirs){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n){
                        continue;
                    }
                    if(grid[newX][newY] == 1){
                        return steps;
                    }
                    if(visited.add(newX + ":" + newY)){
                        q.add(new int[]{newX, newY});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private void dfs(int[][] grid, int x, int y, Queue<int[]> q, Set<String> visited){
        int m = grid.length;
        int n = grid[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited.contains(x + ":" + y)){
            return;
        }
        q.add(new int[]{x, y});
        visited.add(x + ":" + y);
        dfs(grid, x + 1, y, q, visited);
        dfs(grid, x - 1, y, q, visited);
        dfs(grid, x, y + 1, q, visited);
        dfs(grid, x, y - 1, q, visited);
    }
    }
