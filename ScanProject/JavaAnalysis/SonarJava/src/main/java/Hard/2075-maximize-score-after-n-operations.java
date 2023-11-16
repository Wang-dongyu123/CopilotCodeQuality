package main.java.Hard;

/**https://leetcode.com/problems/maximize-score-after-n-operations/ */
//You are given nums, an array of positive integers of size 2 * n. You must perform n operations on this array.
//In the ith operation (1-indexed), you will:
//Choose two elements, x and y.
//Receive a score of i * gcd(x, y).
//Remove x and y from nums.
//Return the maximum score you can receive after performing n operations.
//The function gcd(x, y) is the greatest common divisor of x and y.


class MaximizeScoreAfterNOperations {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = gcd(nums[i], nums[j]);
            }
        }
        int[][] memo = new int[n][1 << n];
        return dfs(0, 0, dp, memo);
        
    }
    public int dfs(int idx, int state, int[][] dp, int[][] memo){
        int n = dp.length;
        if(idx == n){
            return 0;
        }
        if(memo[idx][state] != 0){
            return memo[idx][state];
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            if((state & (1 << i)) == 0){
                res = Math.max(res, dp[idx][i] * (idx + 1) + dfs(idx + 1, state | (1 << i), dp, memo));
            }
        }
        memo[idx][state] = res;
        return res;
    }
    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}
     
    