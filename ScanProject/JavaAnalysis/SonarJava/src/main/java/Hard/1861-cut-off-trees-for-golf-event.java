package main.java.Hard;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**https://leetcode.com/problems/cut-off-trees-for-golf-event/ */
//You are asked to cut off all the trees in a forest for a golf event. The forest is represented as an m x n matrix. In this matrix:
//	0 means the cell cannot be walked through.
//	1 represents an empty cell that can be walked through.
//	A number greater than 1 represents a tree in a cell that can be walked through, and this number is the tree's height.
//In one step, you can walk in any of the four directions: north, east, south, and west. If you are standing in a cell with a tree, you can choose whether to cut it off.
//You must cut off the trees in order from shortest to tallest. When you cut off a tree, the value at its cell becomes 1 (an empty cell).
//Starting from the point (0, 0), return the minimum steps you need to walk to cut off all the trees. If you cannot cut off all the trees, return -1.
//Note: The input is generated such that no two trees have the same height, and there is at least one tree needs to be cut off.
// 
//Example 1:
//Input: forest = [[1,2,3],[0,0,4],[7,6,5]]
//Output: 6
//Explanation: Following the path above allows you to cut off the trees from shortest to tallest in 6 steps.
//Example 2:
//Input: forest = [[1,2,3],[0,0,0],[7,6,5]]
//Output: -1
//Explanation: The trees in the bottom row cannot be accessed as the middle row is blocked.
//Example 3:
//Input: forest = [[2,3,4],[0,0,5],[8,7,6]]
//Output: 6
//Explanation: You can follow the same path as Example 1 to cut off all the trees.
//Note that you can cut off the first tree at (0, 0) before making any steps.
// 
//Constraints:
//	m == forest.length
//	n == forest[i].length
//	1 <= m, n <= 50
//	0 <= forest[i][j] <= 109
//	Heights of all trees are distinct.
class Solution20 {
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int val = forest.get(i).get(j);
                if(val > 1){
                    pq.add(new int[]{i, j, val});
                }
            }
        }
        int[] start = new int[]{0, 0};
        int sum = 0;
        while(!pq.isEmpty()){
            int[] tree = pq.poll();
            int step = bfs(forest, start, tree);
            if(step == -1){
                return -1;
            }
            sum += step;
            start[0] = tree[0];
            start[1] = tree[1];
        }
        return sum;
    }
    private int bfs(List<List<Integer>> forest, int[] start, int[] tree){
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.add(start);
        visited[start[0]][start[1]] = true;
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] cur = q.poll();
                if(cur[0] == tree[0] && cur[1] == tree[1]){
                    return step;
                }
                for(int[] dir : dirs){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || forest.get(x).get(y) == 0){
                        continue;
                    }
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
            step++;
        }
        return -1;
    }
}