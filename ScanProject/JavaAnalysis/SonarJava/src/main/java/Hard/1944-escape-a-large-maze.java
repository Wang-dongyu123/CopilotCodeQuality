package main.java.Hard;

import java.util.HashSet;
import java.util.Set;

/**https://leetcode.com/problems/escape-a-large-maze/ */
//There is a 1 million by 1 million grid on an XY-plane, and the coordinates of each grid square are (x, y).
//We start at the source = [sx, sy] square and want to reach the target = [tx, ty] square. There is also an array of blocked squares, where each blocked[i] = [xi, yi] represents a blocked square with coordinates (xi, yi).
//Each move, we can walk one square north, east, south, or west if the square is not in the array of blocked squares. We are also not allowed to walk outside of the grid.
//Return true if and only if it is possible to reach the target square from the source square through a sequence of valid moves.
// 
//Example 1:
//Input: blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
//Output: false
//Explanation: The target square is inaccessible starting from the source square because we cannot move.
//We cannot move north or east because those squares are blocked.
//We cannot move south or west because we cannot go outside of the grid.
//Example 2:
//Input: blocked = [], source = [0,0], target = [999999,999999]
//Output: true
//Explanation: Because there are no blocked cells, it is possible to reach the target square.
// 
//Constraints:
//	0 <= blocked.length <= 200
//	blocked[i].length == 2
//	0 <= xi, yi < 106
//	source.length == target.length == 2
//	0 <= sx, sy, tx, ty < 106
//	source != target
//	It is guaranteed that source and target are not blocked.
class Solution36 {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> block = new HashSet<>();
        for(int[] b : blocked){
            block.add(b[0] + ":" + b[1]);
        }
        return dfs(block, source, target, new HashSet<>(), 0) && dfs(block, target, source, new HashSet<>(), 0);
    }
    private boolean dfs(Set<String> block, int[] source, int[] target, Set<String> visited, int count){
        if(source[0] == target[0] && source[1] == target[1]){
            return true;
        }
        if(count > 20000 || !visited.add(source[0] + ":" + source[1])){
            return false;
        }
        for(int[] dir : new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}}){
            int x = source[0] + dir[0];
            int y = source[1] + dir[1];
            if(x >= 0 && x < 1000000 && y >= 0 && y < 1000000 && !block.contains(x + ":" + y)){
                if(dfs(block, new int[]{x, y}, target, visited, count + 1)){
                    return true;
                }
            }
        }
        return false;
    }
}