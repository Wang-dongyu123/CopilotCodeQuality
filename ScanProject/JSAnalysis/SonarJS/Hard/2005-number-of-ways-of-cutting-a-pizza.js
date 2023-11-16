/**https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/ */
//Given a rectangular pizza represented as a rows x cols matrix containing the following characters: 'A' (an apple) and '.' (empty cell) and given the integer k. You have to cut the pizza into k pieces using k-1 cuts. 
//For each cut you choose the direction: vertical or horizontal, then you choose a cut position at the cell boundary and cut the pizza into two pieces. If you cut the pizza vertically, give the left part of the pizza to a person. If you cut the pizza horizontally, give the upper part of the pizza to a person. Give the last piece of pizza to the last person.
//Return the number of ways of cutting the pizza such that each piece contains at least one apple. Since the answer can be a huge number, return this modulo 10^9 + 7.


/**
 * @param {string[]} pizza
 * @param {number} k
 * @return {number}
 */
var ways = function(pizza, k) {
    let m = pizza.length;
    let n = pizza[0].length;
    let dp = new Array(m + 1);
    for(let i = 0; i < dp.length; i++){
        dp[i] = new Array(n + 1).fill(0);
    }
    let preSum = new Array(m + 1);
    for(let i = 0; i < preSum.length; i++){
        preSum[i] = new Array(n + 1).fill(0);
    }
    for(let i = 1; i <= m; i++){
        for(let j = 1; j <= n; j++){
            preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            if(pizza[i - 1][j - 1] == 'A'){
                preSum[i][j]++;
            }
        }
    }
    for(let i = 1; i <= m; i++){
        for(let j = 1; j <= n; j++){
            if(preSum[i][j] > 0){
                dp[i][j] = 1;
            }
        }
    }
    for(let cut = 2; cut <= k; cut++){
        let temp = new Array(m + 1);
        for(let i = 0; i < temp.length; i++){
            temp[i] = new Array(n + 1).fill(0);
        }
        for(let i = 1; i <= m; i++){
            for(let j = 1; j <= n; j++){
                for(let x = i - 1; x >= 1; x--){
                    if(preSum[i][j] - preSum[x][j] > 0){
                        temp[i][j] = (temp[i][j] + dp[x][j]) % 1000000007;
                    }
                }
                for(let y = j - 1; y >= 1; y--){
                    if(preSum[i][j] - preSum[i][y] > 0){
                        temp[i][j] = (temp[i][j] + dp[i][y]) % 1000000007;
                    }
                }
            }
        }
        dp = temp;
    }
    return dp[m][n];
};

    