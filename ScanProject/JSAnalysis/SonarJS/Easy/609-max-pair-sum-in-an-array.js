/**https://leetcode.com/problems/max-pair-sum-in-an-array/ */
//You are given a 0-indexed integer array nums. You have to find the maximum sum of a pair of numbers from nums such that the maximum digit in both numbers are equal.
//Return the maximum sum or -1 if no such pair exists.
// 
//Example 1:
//Input: nums = [51,71,17,24,42]
//Output: 88
//Explanation: 
//For i = 1 and j = 2, nums[i] and nums[j] have equal maximum digits with a pair sum of 71 + 17 = 88. 
//For i = 3 and j = 4, nums[i] and nums[j] have equal maximum digits with a pair sum of 24 + 42 = 66.
//It can be shown that there are no other pairs with equal maximum digits, so the answer is 88.
//Example 2:
//Input: nums = [1,2,3,4]
//Output: -1
//Explanation: No pair exists in nums with equal maximum digits.
// 
//Constraints:
//	2 <= nums.length <= 100
//	1 <= nums[i] <= 104
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSum = function(nums) {
    const map = new Map();
    let max = -1;
    for (const num of nums) {
        const digit = Math.max(...num.toString().split(''));
        if (map.has(digit)) {
            max = Math.max(max, map.get(digit) + num);
            map.set(digit, Math.max(map.get(digit), num));
        } else {
            map.set(digit, num);
        }
    }
    return max;
};