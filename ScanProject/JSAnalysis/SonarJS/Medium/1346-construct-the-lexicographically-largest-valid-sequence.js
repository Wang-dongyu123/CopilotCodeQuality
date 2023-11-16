/**https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/ */
//Given an integer n, find a sequence that satisfies all of the following:
//The integer 1 occurs once in the sequence.
//Each integer between 2 and n occurs twice in the sequence.
//For every integer i between 2 and n, the distance between the two occurrences of i is exactly i.
//The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|.
//Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is always a solution.
//A sequence a is lexicographically larger than a sequence b (of the same length) if in the first position where a and b differ, sequence a has a number greater than the corresponding number in b. For example, [0,1,9,0] is lexicographically larger than [0,1,5,6] because the first position they differ is at the third number, and 9 is greater than 5.


/**
 * @param {number} n
 * @return {number[]}
 */
var constructDistancedSequence = function(n) {
    let result = new Array(2 * n - 1).fill(0);
    let visited = new Array(n + 1).fill(false);
    let dfs = function(index) {
        if (index == result.length) {
            return true;
        }
        if (result[index] != 0) {
            return dfs(index + 1);
        }
        for (let i = n; i >= 1; i--) {
            if (visited[i]) {
                continue;
            }
            if (i == 1 || index + i < result.length && result[index + i] == 0) {
                visited[i] = true;
                result[index] = i;
                if (i > 1) {
                    result[index + i] = i;
                }
                if (dfs(index + 1)) {
                    return true;
                }
                visited[i] = false;
                result[index] = 0;
                if (i > 1) {
                    result[index + i] = 0;
                }
            }
        }
        return false;
    }
    dfs(0);
    return result;
    
};

    