package main.java.Medium;

/**https://leetcode.com/problems/jump-game-vii/ */
//You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning, you are standing at index 0, which is equal to '0'. You can move from index i to index j if the following conditions are fulfilled:
//	i + minJump <= j <= min(i + maxJump, s.length - 1), and
//	s[j] == '0'.
//Return true if you can reach index s.length - 1 in s, or false otherwise.
// 
//Example 1:
//Input: s = "011010", minJump = 2, maxJump = 3
//Output: true
//Explanation:
//In the first step, move from index 0 to index 3. 
//In the second step, move from index 3 to index 5.
//Example 2:
//Input: s = "01101110", minJump = 2, maxJump = 3
//Output: false
// 
//Constraints:
//	2 <= s.length <= 105
//	s[i] is either '0' or '1'.
//	s[0] == '0'
//	1 <= minJump <= maxJump < s.length
class Solution202 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int pre = 0;
        for (int i = 1; i < n; i++) {
            if (i >= minJump) {
                pre += dp[i - minJump] ? 1 : 0;
            }
            if (i > maxJump) {
                pre -= dp[i - maxJump - 1] ? 1 : 0;
            }
            dp[i] = pre > 0 && s.charAt(i) == '0';
        }
        return dp[n - 1];
    }
}