package main.java.Hard;

import java.util.Arrays;

/**https://leetcode.com/problems/minimum-cost-to-change-the-final-value-of-expression/ */
//You are given a valid boolean expression as a string expression consisting of the characters '1','0','&' (bitwise AND operator),'|' (bitwise OR operator),'(', and ')'.
//	For example, "()1|1" and "(1)&()" are not valid while "1", "(((1))|(0))", and "1|(0&(1))" are valid expressions.
//Return the minimum cost to change the final value of the expression.
//	For example, if expression = "1|1|(0&0)&1", its value is 1|1|(0&0)&1 = 1|1|0&1 = 1|0&1 = 1&1 = 1. We want to apply operations so that the new expression evaluates to 0.
//The cost of changing the final value of an expression is the number of operations performed on the expression. The types of operations are described as follows:
//	Turn a '1' into a '0'.
//	Turn a '0' into a '1'.
//	Turn a '&' into a '|'.
//	Turn a '|' into a '&'.
//Note: '&' does not take precedence over '|' in the order of calculation. Evaluate parentheses first, then in left-to-right order.
// 
//Example 1:
//Input: expression = "1&(0|1)"
//Output: 1
//Explanation: We can turn "1&(0|1)" into "1&(0&1)" by changing the '|' to a '&' using 1 operation.
//The new expression evaluates to 0. 
//Example 2:
//Input: expression = "(0&0)&(0&0&0)"
//Output: 3
//Explanation: We can turn "(0&0)&(0&0&0)" into "(0|1)|(0&0&0)" using 3 operations.
//The new expression evaluates to 1.
//Example 3:
//Input: expression = "(0|(1|0&1))"
//Output: 1
//Explanation: We can turn "(0|(1|0&1))" into "(0|(0|0&1))" using 1 operation.
//The new expression evaluates to 0.
// 
//Constraints:
//	1 <= expression.length <= 105
//	expression only contains '1','0','&','|','(', and ')'
//	All parentheses are properly matched.
//	There will be no empty parentheses (i.e: "()" is not a substring of expression).
class Solution66 {
    public int minOperationsToFlip(String expression) {
        int n = expression.length();
        int[][] dp = new int[n][2];
        for(int[] d : dp){
            Arrays.fill(d, Integer.MAX_VALUE / 2);
        }
        return dfs(expression, 0, 1, dp);
    }
    private int dfs(String s, int i, int v, int[][] dp){
        if(i == s.length()){
            return v == 0 ? 0 : Integer.MAX_VALUE / 2;
        }
        if(dp[i][v] != Integer.MAX_VALUE / 2){
            return dp[i][v];
        }
        int res = Integer.MAX_VALUE / 2;
        if(s.charAt(i) == '1'){
            res = Math.min(res, dfs(s, i + 1, v ^ 1, dp));
        }else if(s.charAt(i) == '0'){
            res = Math.min(res, dfs(s, i + 1, v, dp));
        }else if(s.charAt(i) == '&'){
            res = Math.min(res, dfs(s, i + 1, v, dp) + 1);
            res = Math.min(res, dfs(s, i + 1, v ^ 1, dp) + 1);
        }else{
            res = Math.min(res, dfs(s, i + 1, v, dp) + 1);
            res = Math.min(res, dfs(s, i + 1, v ^ 1, dp) + 1);
        }
        return dp[i][v] = res;
    }
}