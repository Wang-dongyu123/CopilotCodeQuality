package main.java.Hard;

import java.util.Arrays;

/**https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/ */
//An undirected graph of n nodes is defined by edgeList, where edgeList[i] = [ui, vi, disi] denotes an edge between nodes ui and vi with distance disi. Note that there may be multiple edges between two nodes.
//Given an array queries, where queries[j] = [pj, qj, limitj], your task is to determine for each queries[j] whether there is a path between pj and qj such that each edge on the path has a distance strictly less than limitj .
//Return a boolean array answer, where answer.length == queries.length and the jth value of answer is true if there is a path for queries[j] is true, and false otherwise.
// 
//Example 1:
//Input: n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]
//Output: [false,true]
//Explanation: The above figure shows the given graph. Note that there are two overlapping edges between 0 and 1 with distances 2 and 16.
//For the first query, between 0 and 1 there is no path where each distance is less than 2, thus we return false for this query.
//For the second query, there is a path (0 -> 1 -> 2) of two edges with distances less than 5, thus we return true for this query.
//Example 2:
//Input: n = 5, edgeList = [[0,1,10],[1,2,5],[2,3,9],[3,4,13]], queries = [[0,4,14],[1,4,13]]
//Output: [true,false]
//Explanation: The above figure shows the given graph.
// 
//Constraints:
//	2 <= n <= 105
//	1 <= edgeList.length, queries.length <= 105
//	edgeList[i].length == 3
//	queries[j].length == 3
//	0 <= ui, vi, pj, qj <= n - 1
//	ui != vi
//	pj != qj
//	1 <= disi, limitj <= 109
//	There may be multiple edges between two nodes.
class Solution61 {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int m = queries.length;
        boolean[] res = new boolean[m];
        int[][] query = new int[m][4];
        for (int i = 0; i < m; i++) {
            query[i][0] = queries[i][0];
            query[i][1] = queries[i][1];
            query[i][2] = queries[i][2];
            query[i][3] = i;
        }
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(query, (a, b) -> a[2] - b[2]);
        int idx = 0;
        UnionFind uf = new UnionFind(n);
        for (int[] q : query) {
            while (idx < edgeList.length && edgeList[idx][2] < q[2]) {
                uf.union(edgeList[idx][0], edgeList[idx][1]);
                idx++;
            }
            res[q[3]] = uf.find(q[0]) == uf.find(q[1]);
        }
        return res;
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        private boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return false;
            }
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[px] = py;
                rank[py]++;
            }
            count--;
            return true;
        }
    }
}