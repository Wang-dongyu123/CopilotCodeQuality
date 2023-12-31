/**https://leetcode.com/problems/jump-game-v/ */
//Given an array of integers arr and an integer d. In one step you can jump from index i to index:
//i + x where: i + x < arr.length and 0 < x <= d.
//i - x where: i - x >= 0 and 0 < x <= d.
//In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k] for all indices k between i and j (More formally min(i, j) < k < max(i, j)).
//You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.
//Notice that you can not jump outside of the array at any time.


/**
 * @param {number[]} arr
 * @param {number} d
 * @return {number}
 */
var maxJumps = function(arr, d) {
    let n = arr.length;
    let dp = new Array(n).fill(0);
    let max = 0;
    for(let i = 0; i < n; i++){
        max = Math.max(max, dfs(arr, d, i, dp));
    }
    return max;
    
    
};
function dfs(arr, d, index, dp){
    if(dp[index] > 0){
        return dp[index];
    }
    let max = 1;
    for(let i = index + 1; i <= Math.min(index + d, arr.length - 1) && arr[i] < arr[index]; i++){
        max = Math.max(max, 1 + dfs(arr, d, i, dp));
    }
    for(let i = index - 1; i >= Math.max(index - d, 0) && arr[i] < arr[index]; i--){
        max = Math.max(max, 1 + dfs(arr, d, i, dp));
    }
    dp[index] = max;
    return max;
}

    