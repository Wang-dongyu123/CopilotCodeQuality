/**https://leetcode.com/problems/jump-game-vi/ */
//You are given a 0-indexed integer array nums and an integer k.
//You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.
//You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.
//Return the maximum score you can get.


/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxResult = function(nums, k) {
    let n = nums.length;
    let dp = new Array(n).fill(0);
    dp[0] = nums[0];
    let queue = [0];
    for (let i = 1; i < n; i++) {
        while (queue.length > 0 && queue[0] < i - k) {
            queue.shift();
        }
        dp[i] = dp[queue[0]] + nums[i];
        while (queue.length > 0 && dp[queue[queue.length - 1]] <= dp[i]) {
            queue.pop();
        }
        queue.push(i);
    }
    return dp[n - 1];
    
};

    