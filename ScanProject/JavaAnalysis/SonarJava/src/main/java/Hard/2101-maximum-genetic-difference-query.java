package main.java.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**https://leetcode.com/problems/maximum-genetic-difference-query/ */
//There is a rooted tree consisting of n nodes numbered 0 to n - 1. Each node's number denotes its unique genetic value (i.e. the genetic value of node x is x). The genetic difference between two genetic values is defined as the bitwise-XOR of their values. You are given the integer array parents, where parents[i] is the parent for node i. If node x is the root of the tree, then parents[x] == -1.
//You are also given the array queries where queries[i] = [nodei, vali]. For each query i, find the maximum genetic difference between vali and pi, where pi is the genetic value of any node that is on the path between nodei and the root (including nodei and the root). More formally, you want to maximize vali XOR pi.
//Return an array ans where ans[i] is the answer to the ith query.
// 
//Example 1:
//Input: parents = [-1,0,1,1], queries = [[0,2],[3,2],[2,5]]
//Output: [2,3,7]
//Explanation: The queries are processed as follows:
//- [0,2]: The node with the maximum genetic difference is 0, with a difference of 2 XOR 0 = 2.
//- [3,2]: The node with the maximum genetic difference is 1, with a difference of 2 XOR 1 = 3.
//- [2,5]: The node with the maximum genetic difference is 2, with a difference of 5 XOR 2 = 7.
//Example 2:
//Input: parents = [3,7,-1,2,0,7,0,2], queries = [[4,6],[1,15],[0,5]]
//Output: [6,14,7]
//Explanation: The queries are processed as follows:
//- [4,6]: The node with the maximum genetic difference is 0, with a difference of 6 XOR 0 = 6.
//- [1,15]: The node with the maximum genetic difference is 1, with a difference of 15 XOR 1 = 14.
//- [0,5]: The node with the maximum genetic difference is 2, with a difference of 5 XOR 2 = 7.
// 
//Constraints:
//	2 <= parents.length <= 105
//	0 <= parents[i] <= parents.length - 1 for every node i that is not the root.
//	parents[root] == -1
//	1 <= queries.length <= 3 * 104
//	0 <= nodei <= parents.length - 1
//	0 <= vali <= 2 * 105
class Solution68 {
    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int n = parents.length;
        int m = queries.length;
        int[] res = new int[m];
        int root = -1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(parents[i] == -1){
                root = i;
            }else{
                map.putIfAbsent(parents[i], new ArrayList<>());
                map.get(parents[i]).add(i);
            }
        }
        TrieNode4 rootTrie = new TrieNode4();
        for(int i = 0; i < m; i++){
            int node = queries[i][0];
            int val = queries[i][1];
            rootTrie.insert(val);
            if(map.containsKey(node)){
                dfs(map, node, rootTrie, res, i, queries);
            }
        }
        return res;
    }
    private void dfs(Map<Integer, List<Integer>> map, int cur, TrieNode4 root, int[] res, int index, int[][] queries){
        int val = queries[index][1];
        int max = 0;
        for(int i = 17; i >= 0; i--){
            int bit = (val >> i) & 1;
            if(root.children[1 - bit] != null){
                max += (1 << i);
                root = root.children[1 - bit];
            }else{
                root = root.children[bit];
            }
        }
        res[index] = max;
        if(map.containsKey(cur)){
            for(int next : map.get(cur)){
                dfs(map, next, root, res, index, queries);
            }
        }
    }
    }
class TrieNode4{
    TrieNode4[] children;
    TrieNode4(){
        children = new TrieNode4[2];
    }
    public void insert(int val){
        TrieNode4 root = this;
        for(int i = 17; i >= 0; i--){
            int bit = (val >> i) & 1;
            if(root.children[bit] == null){
                root.children[bit] = new TrieNode4();
            }
            root = root.children[bit];
        }
    }
}