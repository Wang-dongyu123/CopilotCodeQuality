/**https://leetcode.com/problems/find-the-divisibility-array-of-a-string/ */
//You are given a 0-indexed string word of length n consisting of digits, and a positive integer m.
//The divisibility array div of word is an integer array of length n such that:
//	div[i] = 1 if the numeric value of word[0,...,i] is divisible by m, or
//	div[i] = 0 otherwise.
//Return the divisibility array of word.
// 
//Example 1:
//Input: word = "998244353", m = 3
//Output: [1,1,0,0,0,1,1,0,0]
//Explanation: There are only 4 prefixes that are divisible by 3: "9", "99", "998244", and "9982443".
//Example 2:
//Input: word = "1010", m = 10
//Output: [0,1,0,1]
//Explanation: There are only 2 prefixes that are divisible by 10: "10", and "1010".
// 
//Constraints:
//	1 <= n <= 105
//	word.length == n
//	word consists of digits from 0 to 9
//	1 <= m <= 109
/**
 * @param {string} word
 * @param {number} m
 * @return {number[]}
 */
var divisibilityArray = function(word, m) {
    let n = word.length;
    let arr = new Array(n);
    arr[0] = word[0] % m === 0 ? 1 : 0;
    for (let i = 1; i < n; i++) {
        let val = (arr[i-1] * 10 + word[i]) % m;
        arr[i] = val === 0 ? 1 : 0;
    }
    return arr;
};