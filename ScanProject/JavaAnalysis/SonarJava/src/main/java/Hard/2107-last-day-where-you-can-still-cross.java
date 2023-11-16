package main.java.Hard;

/**https://leetcode.com/problems/last-day-where-you-can-still-cross/ */
//There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.
//Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).
//You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).
//Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.
// 
//Example 1:
//Input: row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
//Output: 2
//Explanation: The above image depicts how the matrix changes each day starting from day 0.
//The last day where it is possible to cross from top to bottom is on day 2.
//Example 2:
//Input: row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]
//Output: 1
//Explanation: The above image depicts how the matrix changes each day starting from day 0.
//The last day where it is possible to cross from top to bottom is on day 1.
//Example 3:
//Input: row = 3, col = 3, cells = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]
//Output: 3
//Explanation: The above image depicts how the matrix changes each day starting from day 0.
//The last day where it is possible to cross from top to bottom is on day 3.
// 
//Constraints:
//	2 <= row, col <= 2 * 104
//	4 <= row * col <= 2 * 104
//	cells.length == row * col
//	1 <= ri <= row
//	1 <= ci <= col
//	All the values of cells are unique.
class Solution70 {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = row * col;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        UnionFind uf = new UnionFind(n + 2);
        int[][] grid = new int[row][col];
        for (int i = 0; i < n; i++) {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            grid[x][y] = 1;
            if (x == 0) {
                uf.union(i, n);
            }
            if (x == row - 1) {
                uf.union(i, n + 1);
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col || grid[nx][ny] == 0) {
                    continue;
                }
                uf.union(i, nx * col + ny);
            }
            if (uf.find(n) == uf.find(n + 1)) {
                return i;
            }
        }
        return -1;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                parent[pa] = pb;
            }
        }

        public int find(int a) {
            while (parent[a] != a) {
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }
    }
}