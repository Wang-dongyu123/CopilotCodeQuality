package main.java.Hard;

/**https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/ */
//You are given an integer array nums of 2 * n integers. You need to partition nums into two arrays of length n to minimize the absolute difference of the sums of the arrays. To partition nums, put each element of nums into one of the two arrays.
//Return the minimum possible absolute difference.


class PartitionArrayIntoTwoArraysToMinimizeSumDifference {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        int half = sum/2;
        int[][] dp = new int[n+1][half+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=half;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i-1]]+nums[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return Math.abs(sum-2*dp[n][half]);
        
    }
}
     
    