/**https://leetcode.com/problems/count-numbers-with-unique-digits/ */
//Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.
// 
//Example 1:
//Input: n = 2
//Output: 91
//Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99
//Example 2:
//Input: n = 0
//Output: 1
// 
//Constraints:
//	0 <= n <= 8
/**
 * @param {number} n
 * @return {number}
 */
var countNumbersWithUniqueDigits = function(n) {
    let dp = new Array(n+1).fill(0);
    dp[0] = 1;
    for(let i = 1; i <= n; i++){
        let count = 9;
        for(let j = 1; j < i; j++){
            count *= (10-j);
        }
        dp[i] = dp[i-1] + count;
    }
    return dp[n];
};