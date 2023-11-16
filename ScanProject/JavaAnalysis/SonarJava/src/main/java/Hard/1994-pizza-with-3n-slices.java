package main.java.Hard;

/**https://leetcode.com/problems/pizza-with-3n-slices/ */
//There is a pizza with 3n slices of varying size, you and your friends will take slices of pizza as follows:
//You will pick any pizza slice.
//Your friend Alice will pick the next slice in the anti-clockwise direction of your pick.
//Your friend Bob will pick the next slice in the clockwise direction of your pick.
//Repeat until there are no more slices of pizzas.
//Given an integer array slices that represent the sizes of the pizza slices in a clockwise direction, return the maximum possible sum of slice sizes that you can pick.


class PizzaWith3NSlices {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int m = n / 3;
        return Math.max(maxSum(slices, 0, n - 2, m), maxSum(slices, 1, n - 1, m));
      
    }
    public int maxSum(int[] slices, int start, int end, int m) {
        int n = end - start + 1;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], (i - 2 >= 0 ? dp[i - 2][j - 1] : 0) + slices[start + i - 1]);
            }
        }
        return dp[n][m];
    }
}
     
    