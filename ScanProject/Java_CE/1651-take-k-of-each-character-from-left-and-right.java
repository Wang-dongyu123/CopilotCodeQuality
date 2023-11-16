package main.java.Medium;

/**https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/ */
//You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. Each minute, you may take either the leftmost character of s, or the rightmost character of s.
//Return the minimum number of minutes needed for you to take at least k of each character, or return -1 if it is not possible to take k of each character.


class TakeKOfEachCharacterFromLeftAndRight {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[][][] dp = new int[n][k + 1][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l < 3; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return helper(s, 0, k, 0, dp);
    }
    private int helper(String s, int index, int k, int count, int[][][] dp) {
        if (index == s.length()) {
            if (count == k) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if (dp[index][count][k] != -1) {
            return dp[index][count][k];
        }
        int ans = Integer.MAX_VALUE;
        if (count == k) {
            ans = 0;
        } else {
            ans = Math.min(ans, helper(s, index + 1, k, count, dp));
        }
        if (s.charAt(index) == 'a') {
            ans = Math.min(ans, 1 + helper(s, index + 1, k, count + 1, dp));
        } else if (s.charAt(index) == 'b') {
            ans = Math.min(ans, 1 + helper(s, index + 1, k, count + 1, dp));
        } else {
            ans = Math.min(ans, 1 + helper(s, index + 1, k, count + 1, dp));
        }
        dp[index][count][k] = ans;
        return ans;


    }
}

    