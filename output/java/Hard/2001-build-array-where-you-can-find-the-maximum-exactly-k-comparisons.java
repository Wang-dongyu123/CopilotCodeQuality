/**https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/ */
//You are given three integers n, m and k. Consider the following algorithm to find the maximum element of an array of positive integers:
//You should build the array arr which has the following properties:
//	arr has exactly n integers.
//	1 <= arr[i] <= m where (0 <= i < n).
//	After applying the mentioned algorithm to arr, the value search_cost is equal to k.
//Return the number of ways to build the array arr under the mentioned conditions. As the answer may grow large, the answer must be computed modulo 109 + 7.
// 
//Example 1:
//Input: n = 2, m = 3, k = 1
//Output: 6
//Explanation: The possible arrays are [1, 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]
//Example 2:
//Input: n = 5, m = 2, k = 3
//Output: 0
//Explanation: There are no possible arrays that satisify the mentioned conditions.
//Example 3:
//Input: n = 9, m = 1, k = 1
//Output: 1
//Explanation: The only possible array is [1, 1, 1, 1, 1, 1, 1, 1, 1]
// 
//Constraints:
//	1 <= n <= 50
//	1 <= m <= 100
//	0 <= k <= n
class Solution {
    public int numOfArrays(int n, int m, int k) {
        int mod = 1000000007;
        int[][][] dp = new int[n + 1][m + 1][k + 1];
        for(int i = 1; i <= m; i++){
            dp[1][i][1] = 1;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= m; j++){
                for(int l = 1; l <= k; l++){
                    dp[i][j][l] = (dp[i][j][l] + dp[i - 1][j][l] * j) % mod;
                    for(int p = 1; p < j; p++){
                        dp[i][j][l] = (dp[i][j][l] + dp[i - 1][p][l - 1]) % mod;
                    }
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= m; i++){
            res = (res + dp[n][i][k]) % mod;
        }
        return res;
    }
}