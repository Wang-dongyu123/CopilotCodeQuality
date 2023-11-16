package main.java.Hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**https://leetcode.com/problems/strange-printer-ii/ */
//There is a strange printer with the following two special requirements:
//	On each turn, the printer will print a solid rectangular pattern of a single color on the grid. This will cover up the existing colors in the rectangle.
//	Once the printer has used a color for the above operation, the same color cannot be used again.
//You are given a m x n matrix targetGrid, where targetGrid[row][col] is the color in the position (row, col) of the grid.
//Return true if it is possible to print the matrix targetGrid, otherwise, return false.
// 
//Example 1:
//Input: targetGrid = [[1,1,1,1],[1,2,2,1],[1,2,2,1],[1,1,1,1]]
//Output: true
//Example 2:
//Input: targetGrid = [[1,1,1,1],[1,1,3,3],[1,1,3,4],[5,5,1,4]]
//Output: true
//Example 3:
//Input: targetGrid = [[1,2,1],[2,1,2],[1,2,1]]
//Output: false
//Explanation: It is impossible to form targetGrid because it is not allowed to print the same color in different turns.
// 
//Constraints:
//	m == targetGrid.length
//	n == targetGrid[i].length
//	1 <= m, n <= 60
//	1 <= targetGrid[row][col] <= 60
class Solution56 {
    public boolean isPrintable(int[][] targetGrid) {
        int m = targetGrid.length, n = targetGrid[0].length;
        int[] left = new int[61], right = new int[61], up = new int[61], down = new int[61];
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(up, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MIN_VALUE);
        Arrays.fill(down, Integer.MIN_VALUE);
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0;j < n; j++){
                int color = targetGrid[i][j];
                left[color] = Math.min(left[color], j);
                right[color] = Math.max(right[color], j);
                up[color] = Math.min(up[color], i);
                down[color] = Math.max(down[color], i);
                set.add(color);
            }
        }
        while(!set.isEmpty()){
            boolean flag = false;
            for(int i = 1; i <= 60; i++){
                if(set.contains(i) && left[i] != right[i] && up[i] != down[i]){
                    flag = true;
                    for(int x = up[i]; x <= down[i]; x++){
                        for(int y = left[i]; y <= right[i]; y++){
                            if(targetGrid[x][y] != 0 && targetGrid[x][y] != i){
                                targetGrid[x][y] = 0;
                                set.remove(targetGrid[x][y]);
                            }
                        }
                    }
                    left[i] = Integer.MAX_VALUE;
                    right[i] = Integer.MIN_VALUE;
                    up[i] = Integer.MAX_VALUE;
                    down[i] = Integer.MIN_VALUE;
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }
}