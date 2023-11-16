package main.java.Hard;

/**https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/ */
//Given a rectangular pizza represented as a rows x cols matrix containing the following characters: 'A' (an apple) and '.' (empty cell) and given the integer k. You have to cut the pizza into k pieces using k-1 cuts. 
//For each cut you choose the direction: vertical or horizontal, then you choose a cut position at the cell boundary and cut the pizza into two pieces. If you cut the pizza vertically, give the left part of the pizza to a person. If you cut the pizza horizontally, give the upper part of the pizza to a person. Give the last piece of pizza to the last person.
//Return the number of ways of cutting the pizza such that each piece contains at least one apple. Since the answer can be a huge number, return this modulo 10^9 + 7.


class NumberOfWaysOfCuttingAPizza {
    public int ways(String[] pizza, int k) {
        int mod = 1000000007;
        int m = pizza.length;
        int n = pizza[0].length();
        int[][] preSum = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + (pizza[i - 1].charAt(j - 1) == 'A' ? 1 : 0);
            }
        }
        int[][][] dp = new int[m + 1][n + 1][k + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                for(int l = 0; l <= k; l++){
                    dp[i][j][l] = -1;
                }
            }
        }
        return dfs(m, n, k, preSum, 0, 0, dp) % mod;
        
        
    }
    public int dfs(int m, int n, int k, int[][] preSum, int i, int j, int[][][] dp){
        int mod = 1000000007;
        if(k == 1){
            return preSum[m][n] - preSum[i][n] - preSum[m][j] + preSum[i][j] > 0 ? 1 : 0;
        }
        if(dp[i][j][k] != -1){
            return dp[i][j][k];
        }
        long res = 0;
        for(int r = i + 1; r < m; r++){
            if(preSum[r][n] - preSum[i][n] - preSum[r][j] + preSum[i][j] > 0){
                res += dfs(m, n, k - 1, preSum, r, j, dp);
                res %= mod;
            }
        }
        for(int c = j + 1; c < n; c++){
            if(preSum[m][c] - preSum[i][c] - preSum[m][j] + preSum[i][j] > 0){
                res += dfs(m, n, k - 1, preSum, i, c, dp);
                res %= mod;
            }
        }
        dp[i][j][k] = (int)res;
        return dp[i][j][k];
    }
}
     
    