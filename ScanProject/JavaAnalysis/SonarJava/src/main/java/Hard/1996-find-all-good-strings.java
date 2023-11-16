package main.java.Hard;

/**https://leetcode.com/problems/find-all-good-strings/ */
//Given the strings s1 and s2 of size n and the string evil, return the number of good strings.
//A good string has size n, it is alphabetically greater than or equal to s1, it is alphabetically smaller than or equal to s2, and it does not contain the string evil as a substring. Since the answer can be a huge number, return this modulo 10^9 + 7.


class FindAllGoodStrings {
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        int mod = 1000000007;
        int[][][] dp = new int[n + 1][s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= s1.length(); j++){
                for(int k = 0; k <= s2.length(); k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return dfs(n, s1, s2, evil, 0, 0, 0, dp) % mod;
        
        
    }
    public int dfs(int n, String s1, String s2, String evil, int i, int j, int k, int[][][] dp){
        int mod = 1000000007;
        if(j == s1.length() || k == s2.length()){
            return 0;
        }
        if(i == n){
            return 1;
        }
        if(dp[i][j][k] != -1){
            return dp[i][j][k];
        }
        long res = 0;
        for(char c = 'a'; c <= 'z'; c++){
            if(c == evil.charAt(i)){
                continue;
            }
            if(c < s1.charAt(j) || c > s2.charAt(k)){
                continue;
            }
            int nj = j + 1;
            int nk = k + 1;
            while(nj < s1.length() && s1.charAt(nj) == c){
                nj++;
            }
            while(nk < s2.length() && s2.charAt(nk) == c){
                nk++;
            }
            res += dfs(n, s1, s2, evil, i + 1, nj, nk, dp);
            res %= mod;
        }
        dp[i][j][k] = (int)res;
        return dp[i][j][k];
    }
}
     
    