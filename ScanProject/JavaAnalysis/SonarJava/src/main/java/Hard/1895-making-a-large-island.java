package main.java.Hard;

import java.util.HashSet;
import java.util.Set;

/**https://leetcode.com/problems/making-a-large-island/ */
//You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1._x000D_
//_x000D_
//Return the size of the largest island in grid after applying this operation._x000D_
//_x000D_
//An island is a 4-directionally connected group of 1s._x000D_
//_x000D_
// _x000D_
//Example 1:_x000D_
//_x000D_
//_x000D_
//Input: grid = [[1,0],[0,1]]_x000D_
//Output: 3_x000D_
//Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3._x000D_
//_x000D_
//_x000D_
//Example 2:_x000D_
//_x000D_
//_x000D_
//Input: grid = [[1,1],[1,0]]_x000D_
//Output: 4_x000D_
//Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4._x000D_
//_x000D_
//Example 3:_x000D_
//_x000D_
//_x000D_
//Input: grid = [[1,1],[1,1]]_x000D_
//Output: 4_x000D_
//Explanation: Can't change any 0 to 1, only one island with area = 4._x000D_
//_x000D_
//_x000D_
// _x000D_
//Constraints:_x000D_
//_x000D_
//_x000D_
//	n == grid.length_x000D_
//	n == grid[i].length_x000D_
//	1 <= n <= 500_x000D_
//	grid[i][j] is either 0 or 1._x000D_
class Solution28 {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[] area = new int[n * n + 2];
        int index = 2;
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0;j < n; j++){
                if(grid[i][j] == 1){
                    area[index] = dfs(grid, i, j, index);
                    res = Math.max(res, area[index++]);
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0;j < n; j++){
                if(grid[i][j] == 0){
                    Set<Integer> set = new HashSet<>();
                    for(int[] dir : new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}}){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if(x >= 0 && x < n && y >= 0 && y < n && grid[x][y] > 1){
                            set.add(grid[x][y]);
                        }
                    }
                    int sum = 1;
                    for(int num : set){
                        sum += area[num];
                    }
                    res = Math.max(res, sum);
                }
            }
        }
        return res;
    }
    private int dfs(int[][] grid, int i, int j, int index){
        int n = grid.length;
        if(i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1){
            return 0;
        }
        grid[i][j] = index;
        return 1 + dfs(grid, i + 1, j, index) + dfs(grid, i - 1, j, index) + dfs(grid, i, j + 1, index) + dfs(grid, i, j - 1, index);
    }
}