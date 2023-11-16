package main.java.Medium;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/numbers-with-same-consecutive-differences/ */
//Given two integers n and k, return an array of all the integers of length n where the difference between every two consecutive digits is k. You may return the answer in any order.
//Note that the integers should not have leading zeros. Integers as 02 and 043 are not allowed.
// 
//Example 1:
//Input: n = 3, k = 7
//Output: [181,292,707,818,929]
//Explanation: Note that 070 is not a valid number, because it has leading zeroes.
//Example 2:
//Input: n = 2, k = 1
//Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
// 
//Constraints:
//	2 <= n <= 9
//	0 <= k <= 9
class Solution6 {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            dfs(res, i, n, k, 1);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    private void dfs(List<Integer> res, int cur, int n, int k, int len){
        if(len == n){
            res.add(cur);
            return;
        }
        int last = cur % 10;
        if(last + k < 10){
            dfs(res, cur * 10 + last + k, n, k, len + 1);
        }
        if(last - k >= 0 && k != 0){
            dfs(res, cur * 10 + last - k, n, k, len + 1);
        }
    }
}