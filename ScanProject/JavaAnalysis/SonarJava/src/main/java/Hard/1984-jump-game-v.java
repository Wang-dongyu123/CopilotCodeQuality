package main.java.Hard;

/**https://leetcode.com/problems/jump-game-v/ */
//Given an array of integers arr and an integer d. In one step you can jump from index i to index:
//i + x where: i + x < arr.length and 0 < x <= d.
//i - x where: i - x >= 0 and 0 < x <= d.
//In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k] for all indices k between i and j (More formally min(i, j) < k < max(i, j)).
//You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.
//Notice that you can not jump outside of the array at any time.


class JumpGameV {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(arr, d, i, dp));
        }
        return res;
        
    }
    public int dfs(int[] arr, int d, int cur, int[] dp) {
        if (dp[cur] != 0) {
            return dp[cur];
        }
        int res = 1;
        for (int i = 1; i <= d && cur + i < arr.length && arr[cur + i] < arr[cur]; i++) {
            res = Math.max(res, 1 + dfs(arr, d, cur + i, dp));
        }
        for (int i = 1; i <= d && cur - i >= 0 && arr[cur - i] < arr[cur]; i++) {
            res = Math.max(res, 1 + dfs(arr, d, cur - i, dp));
        }
        dp[cur] = res;
        return res;
    }
}
     
    