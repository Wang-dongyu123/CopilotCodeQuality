package main.java.Medium;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/possible-bipartition/ */
//We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.
//Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
// 
//Example 1:
//Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
//Output: true
//Explanation: The first group has [1,4], and the second group has [2,3].
//Example 2:
//Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
//Output: false
//Explanation: We need at least 3 groups to divide them. We cannot put them in two groups.
// 
//Constraints:
//	1 <= n <= 2000
//	0 <= dislikes.length <= 104
//	dislikes[i].length == 2
//	1 <= ai < bi <= n
//	All the pairs of dislikes are unique.
class Solution1 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> map = new ArrayList<>();
        for(int i = 0; i < n; i++){
            map.add(new ArrayList<>());
        }
        for(int[] dislike : dislikes){
            map.get(dislike[0] - 1).add(dislike[1] - 1);
            map.get(dislike[1] - 1).add(dislike[0] - 1);
        }
        int[] color = new int[n];
        for(int i = 0; i < n; i++){
            if(color[i] == 0 && !dfs(map, color, i, 1)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> map, int[] color, int cur, int c){
        color[cur] = c;
        for(int next : map.get(cur)){
            if(color[next] == c){
                return false;
            }else if(color[next] == 0 && !dfs(map, color, next, -c)){
                return false;
            }
        }
        return true;
    }
}