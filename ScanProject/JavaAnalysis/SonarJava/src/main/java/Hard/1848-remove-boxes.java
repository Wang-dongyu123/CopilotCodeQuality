package main.java.Hard;

/**https://leetcode.com/problems/remove-boxes/ */
//You are given several boxes with different colors represented by different positive numbers.
//You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (i.e., composed of k boxes, k >= 1), remove them and get k * k points.
//Return the maximum points you can get.


class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return removeBoxesSub(boxes, dp, 0, n - 1, 0);
        
        
    }
    public int removeBoxesSub(int[] boxes, int[][][] dp, int l, int r, int k){
        if(l > r){
            return 0;
        }
        if(dp[l][r][k] != 0){
            return dp[l][r][k];
        }
        while(r > l && boxes[r] == boxes[r - 1]){
            r--;
            k++;
        }
        dp[l][r][k] = removeBoxesSub(boxes, dp, l, r - 1, 0) + (k + 1) * (k + 1);
        for(int i = l; i < r; i++){
            if(boxes[i] == boxes[r]){
                dp[l][r][k] = Math.max(dp[l][r][k], removeBoxesSub(boxes, dp, l, i, k + 1) + removeBoxesSub(boxes, dp, i + 1, r - 1, 0));
            }
        }
        return dp[l][r][k];
    }
}
     
    