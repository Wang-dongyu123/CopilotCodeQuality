package main.java.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**https://leetcode.com/problems/sum-of-distances-in-tree/ */
//There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
//You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
//Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.
// 
//Example 1:
//Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
//Output: [8,12,6,10,10,10]
//Explanation: The tree is shown above.
//We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
//equals 1 + 1 + 2 + 2 + 2 = 8.
//Hence, answer[0] = 8, and so on.
//Example 2:
//Input: n = 1, edges = []
//Output: [0]
//Example 3:
//Input: n = 2, edges = [[1,0]]
//Output: [1,1]
// 
//Constraints:
//	1 <= n <= 3 * 104
//	edges.length == n - 1
//	edges[i].length == 2
//	0 <= ai, bi < n
//	ai != bi
//	The given input represents a valid tree.
class Solution29 {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] res = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);
        List<List<Integer>> map = new ArrayList<>();
        for(int i = 0; i < n; i++){
            map.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        dfs(map, 0, -1, count, res);
        dfs2(map, 0, -1, count, res, n);
        return res;
    }
    private void dfs(List<List<Integer>> map, int cur, int pre, int[] count, int[] res){
        for(int next : map.get(cur)){
            if(next != pre){
                dfs(map, next, cur, count, res);
                count[cur] += count[next];
                res[cur] += res[next] + count[next];
            }
        }
    }
    private void dfs2(List<List<Integer>> map, int cur, int pre, int[] count, int[] res, int n){
        for(int next : map.get(cur)){
            if(next != pre){
                res[next] = res[cur] - count[next] + n - count[next];
                dfs2(map, next, cur, count, res, n);
            }
        }
    }
        
    }
