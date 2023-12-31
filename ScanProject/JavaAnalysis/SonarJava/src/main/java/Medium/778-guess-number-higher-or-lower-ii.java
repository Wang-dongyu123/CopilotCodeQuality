package main.java.Medium;

/**https://leetcode.com/problems/guess-number-higher-or-lower-ii/ */
//We are playing the Guessing Game. The game will work as follows:
//I pick a number between 1 and n.
//You guess a number.
//If you guess the right number, you win the game.
//If you guess the wrong number, then I will tell you whether the number I picked is higher or lower, and you will continue guessing.
//Every time you guess a wrong number x, you will pay x dollars. If you run out of money, you lose the game.
//Given a particular n, return the minimum amount of money you need to guarantee a win regardless of what number I pick.


class GuessNumberHigherOrLowerIi {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 2; i <= n; i++){
            for(int j = i - 1; j > 0; j--){
                int min = Integer.MAX_VALUE;
                for(int k = j + 1; k < i; k++){
                    min = Math.min(min, k + Math.max(dp[j][k - 1], dp[k + 1][i]));
                }
                dp[j][i] = j + 1 == i ? j : min;
            }
        }
        return dp[1][n];
        
    }
}

    