package main.java.Medium;

/**https://leetcode.com/problems/count-ways-to-build-good-strings/ */
//Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at each step perform either of the following:
//Append the character '0' zero times.
//Append the character '1' one times.
//This can be performed any number of times.
//A good string is a string constructed by the above process having a length between low and high (inclusive).
//Return the number of different good strings that can be constructed satisfying these properties. Since the answer can be large, return it modulo 109 + 7.


class CountWaysToBuildGoodStrings {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1000000007;
        int[][][] dp = new int[low + 1][high + 1][2];
        for(int i = 0; i <= low; i++){
            for(int j = 0; j <= high; j++){
                for(int k = 0; k < 2; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return dfs(low, high, zero, one, 0, 0, 0, dp) % mod;
        
        
    }
    public int dfs(int low, int high, int zero, int one, int i, int l, int r, int[][][] dp){
        if(i == high + 1){
            return 1;
        }
        if(dp[i][l][r] != -1){
            return dp[i][l][r];
        }
        int res = 0;
        if(i >= low && i <= high && l <= zero && r <= one){
            res++;
        }
        res += dfs(low, high, zero, one, i + 1, l + 1, r, dp);
        res += dfs(low, high, zero, one, i + 1, l, r + 1, dp);
        return dp[i][l][r] = res;
    }
}
     
    