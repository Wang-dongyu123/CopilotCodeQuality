package main.java.Hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**https://leetcode.com/problems/shortest-path-to-get-all-keys/ */
//You are given an m x n grid grid where:
//	'.' is an empty cell.
//	'#' is a wall.
//	'@' is the starting point.
//	Lowercase letters represent keys.
//	Uppercase letters represent locks.
//You start at the starting point and one move consists of walking one space in one of the four cardinal directions. You cannot walk outside the grid, or walk into a wall.
//If you walk over a key, you can pick it up and you cannot walk over a lock unless you have its corresponding key.
//For some 1 <= k <= 6, there is exactly one lowercase and one uppercase letter of the first k letters of the English alphabet in the grid. This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.
//Return the lowest number of moves to acquire all keys. If it is impossible, return -1.
// 
//Example 1:
//Input: grid = ["@.a..","###.#","b.A.B"]
//Output: 8
//Explanation: Note that the goal is to obtain all the keys not to open all the locks.
//Example 2:
//Input: grid = ["@..aA","..B#.","....b"]
//Output: 6
//Example 3:
//Input: grid = ["@Aa"]
//Output: -1
// 
//Constraints:
//	m == grid.length
//	n == grid[i].length
//	1 <= m, n <= 30
//	grid[i][j] is either an English letter, '.', '#', or '@'. 
//	There is exactly one '@' in the grid.
//	The number of keys in the grid is in the range [1, 6].
//	Each key in the grid is unique.
//	Each key in the grid has a matching lock.
class Solution30 {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int allKeys = 0;
        int steps = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char c = grid[i].charAt(j);
                if(c == '@'){
                    q.add(new int[]{i, j, 0});
                    visited.add(i + ":" + j + ":" + 0);
                }
                if(c >= 'a' && c <= 'f'){
                    allKeys |= (1 << (c - 'a'));
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int keys = cur[2];
                if(keys == allKeys){
                    return steps;
                }
                for(int[] dir : dirs){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n){
                        continue;
                    }
                    char c = grid[newX].charAt(newY);
                    if(c == '#'){
                        continue;
                    }
                    if(c >= 'A' && c <= 'F' && ((keys >> (c - 'A')) & 1) == 0){
                        continue;
                    }
                    int newKeys = keys;
                    if(c >= 'a' && c <= 'f'){
                        newKeys |= (1 << (c - 'a'));
                    }
                    String key = newX + ":" + newY + ":" + newKeys;
                    if(visited.contains(key)){
                        continue;
                    }
                    q.add(new int[]{newX, newY, newKeys});
                    visited.add(key);
                }
            }
            steps++;
        }
        return -1;
    }
}