/**https://leetcode.com/problems/stone-game-iii/ */
//Alice and Bob continue their games with piles of stones. There are several stones arranged in a row, and each stone has an associated value which is an integer given in the array stoneValue.
//Alice and Bob take turns, with Alice starting first. On each player's turn, that player can take 1, 2, or 3 stones from the first remaining stones in the row.
//The score of each player is the sum of the values of the stones taken. The score of each player is 0 initially.
//The objective of the game is to end with the highest score, and the winner is the player with the highest score and there could be a tie. The game continues until all the stones have been taken.
//Assume Alice and Bob play optimally.
//Return "Alice" if Alice will win, "Bob" if Bob will win, or "Tie" if they will end the game with the same score.


/**
 * @param {number[]} stoneValue
 * @return {string}
 */
var stoneGameIII = function(stoneValue) {
    let n = stoneValue.length;
    let dp = new Array(n + 1).fill(0);
    for(let i = n - 1; i >= 0; i--){
        let sum = 0;
        let max = -Infinity;
        for(let j = i; j < i + 3 && j < n; j++){
            sum += stoneValue[j];
            max = Math.max(max, sum - dp[j + 1]);
        }
        dp[i] = max;
    }
    if(dp[0] > 0) return "Alice";
    if(dp[0] < 0) return "Bob";
    return "Tie";
    
};

    