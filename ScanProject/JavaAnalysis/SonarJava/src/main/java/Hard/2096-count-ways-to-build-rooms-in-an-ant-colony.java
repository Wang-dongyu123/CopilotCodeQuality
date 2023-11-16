package main.java.Hard;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/count-ways-to-build-rooms-in-an-ant-colony/ */
//You are an ant tasked with adding n new rooms numbered 0 to n-1 to your colony. You are given the expansion plan as a 0-indexed integer array of length n, prevRoom, where prevRoom[i] indicates that you must build room prevRoom[i] before building room i, and these two rooms must be connected directly. Room 0 is already built, so prevRoom[0] = -1. The expansion plan is given such that once all the rooms are built, every room will be reachable from room 0._x000D_
//_x000D_
//You can only build one room at a time, and you can travel freely between rooms you have already built only if they are connected. You can choose to build any room as long as its previous room is already built._x000D_
//_x000D_
//Return the number of different orders you can build all the rooms in. Since the answer may be large, return it modulo 109 + 7._x000D_
//_x000D_
// _x000D_
//Example 1:_x000D_
//_x000D_
//_x000D_
//Input: prevRoom = [-1,0,1]_x000D_
//Output: 1_x000D_
//Explanation: There is only one way to build the additional rooms: 0 → 1 → 2_x000D_
//_x000D_
//_x000D_
//Example 2:_x000D_
//_x000D_
//_x000D_
//_x000D_
//Input: prevRoom = [-1,0,0,1,2]_x000D_
//Output: 6_x000D_
//Explanation:_x000D_
//The 6 ways are:_x000D_
//0 → 1 → 3 → 2 → 4_x000D_
//0 → 2 → 4 → 1 → 3_x000D_
//0 → 1 → 2 → 3 → 4_x000D_
//0 → 1 → 2 → 4 → 3_x000D_
//0 → 2 → 1 → 3 → 4_x000D_
//0 → 2 → 1 → 4 → 3_x000D_
//_x000D_
//_x000D_
// _x000D_
//Constraints:_x000D_
//_x000D_
//_x000D_
//	n == prevRoom.length_x000D_
//	2 <= n <= 105_x000D_
//	prevRoom[0] == -1_x000D_
//	0 <= prevRoom[i] < n for all 1 <= i < n_x000D_
//	Every room is reachable from room 0 once all the rooms are built._x000D_
class Solution67 {
    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 1; i < n; i++){
            graph[prevRoom[i]].add(i);
        }
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for(int i = 1; i <= n; i++){
            factorial[i] = (int)((long)factorial[i - 1] * i % 1000000007);
        }
        int[] dp = new int[n];
        dfs(graph, 0, factorial, dp);
        return dp[0];
    }
    private void dfs(List<Integer>[] graph, int root, int[] factorial, int[] dp){
        dp[root] = 1;
        for(int child : graph[root]){
            dfs(graph, child, factorial, dp);
            dp[root] = (int)((long)dp[root] * dp[child] % 1000000007 * inverse(factorial[dp[child]]) % 1000000007);
        }
        dp[root] = (int)((long)dp[root] * factorial[graph[root].size()] % 1000000007);
    }
    private int inverse(int num){
        return power(num, 1000000007 - 2);
    }
    private int power(int num, int exp){
        int res = 1;
        while(exp > 0){
            if((exp & 1) == 1){
                res = (int)((long)res * num % 1000000007);
            }
            num = (int)((long)num * num % 1000000007);
            exp >>= 1;
        }
        return res;
    }
}


