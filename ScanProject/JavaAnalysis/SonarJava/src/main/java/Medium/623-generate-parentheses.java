package main.java.Medium;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/generate-parentheses/ */
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
// 
//Example 1:
//Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
//Example 2:
//Input: n = 1
//Output: ["()"]
// 
//Constraints:
//	1 <= n <= 8
class Solution445 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, n, "");
        return res;
    }
    public void dfs(List<String> res, int left, int right, String path) {
        if (left == 0 && right == 0) {
            res.add(path);
            return;
        }
        if (left > 0) {
            dfs(res, left - 1, right, path + "(");
        }
        if (right > 0 && right > left) {
            dfs(res, left, right - 1, path + ")");
        }
    }
    }
