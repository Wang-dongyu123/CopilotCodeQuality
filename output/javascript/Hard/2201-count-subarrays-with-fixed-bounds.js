/**https://leetcode.com/problems/count-subarrays-with-fixed-bounds/ */
//You are given an integer array nums and two integers minK and maxK.
//A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
//	The minimum value in the subarray is equal to minK.
//	The maximum value in the subarray is equal to maxK.
//Return the number of fixed-bound subarrays.
//A subarray is a contiguous part of an array.
// 
//Example 1:
//Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
//Output: 2
//Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
//Example 2:
//Input: nums = [1,1,1,1], minK = 1, maxK = 1
//Output: 10
//Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
// 
//Constraints:
//	2 <= nums.length <= 105
//	1 <= nums[i], minK, maxK <= 106
/**
 * @param {number[]} nums
 * @param {number} minK
 * @param {number} maxK
 * @return {number}
 */
var countSubarrays = function(nums, minK, maxK) {
    let result = 0;
    let j = 0;
    let k = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] >= minK) {
            j++;
        }
        if (nums[i] > maxK) {
            k = 0;
        } else {
            k++;
        }
        result += j - k;
    }
    return result;
};