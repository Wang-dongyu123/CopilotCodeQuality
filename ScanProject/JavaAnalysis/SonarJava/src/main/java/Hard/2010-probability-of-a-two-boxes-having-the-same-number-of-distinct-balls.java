package main.java.Hard;

/**https://leetcode.com/problems/probability-of-a-two-boxes-having-the-same-number-of-distinct-balls/ */
//Given 2n balls of k distinct colors. You will be given an integer array balls of size k where balls[i] is the number of balls of color i.
//All the balls will be shuffled uniformly at random, then we will distribute the first n balls to the first box and the remaining n balls to the other box (Please read the explanation of the second example carefully).
//Please note that the two boxes are considered different. For example, if we have two balls of colors a and b, and two boxes [] and (), then the distribution [a] (b) is considered different than the distribution [b] (a) (Please read the explanation of the first example carefully).
//Return the probability that the two boxes have the same number of distinct balls. Answers within 10-5 of the actual value will be accepted as correct.


class ProbabilityOfATwoBoxesHavingTheSameNumberOfDistinctBalls {
    public double getProbability(int[] balls) {
        int n = balls.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += balls[i];
        }
        int[][] dp = new int[sum + 1][sum + 1];
        for(int i = 0; i <= sum; i++){
            for(int j = 0; j <= sum; j++){
                dp[i][j] = -1;
            }
        }
        int total = dfs(balls, 0, 0, 0, dp);
        int same = 0;
        for(int i = 0; i <= sum; i++){
            same += dfs(balls, 0, i, i, dp);
        }
        return (double)same / total;
        
        
    }
    public int dfs(int[] balls, int i, int sum1, int sum2, int[][] dp){
        int n = balls.length;
        if(sum1 > sum2){
            return 0;
        }
        if(i == n){
            return sum1 == sum2 ? 1 : 0;
        }
        if(dp[sum1][sum2] != -1){
            return dp[sum1][sum2];
        }
        int res = 0;
        for(int j = 0; j <= balls[i]; j++){
            res += dfs(balls, i + 1, sum1 + j, sum2 + balls[i] - j, dp);
        }
        dp[sum1][sum2] = res;
        return res;
    }
}
     
    