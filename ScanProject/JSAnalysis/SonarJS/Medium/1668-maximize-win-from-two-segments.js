/**https://leetcode.com/problems/maximize-win-from-two-segments/ */
//There are some prizes on the X-axis. You are given an integer array prizePositions that is sorted in non-decreasing order, where prizePositions[i] is the position of the ith prize. There could be different prizes at the same position on the line. You are also given an integer k.
//You are allowed to select two segments with integer endpoints. The length of each segment must be k. You will collect all prizes whose position falls within at least one of the two selected segments (including the endpoints of the segments). The two selected segments may intersect.
//For example if k = 2, you can choose segments [1, 3] and [2, 4], and you will win any prize i that satisfies 1 <= prizePositions[i] <= 3 or 2 <= prizePositions[i] <= 4.
//Return the maximum number of prizes you can win if you choose the two segments optimally.


/**
 * @param {number[]} prizePositions
 * @param {number} k
 * @return {number}
 */
var maximizeWin = function(prizePositions, k) {
    let max = 0;
    let left = 0;
    let right = 0;
    let count = 0;
    while(right < prizePositions.length){
        while(prizePositions[right] - prizePositions[left] + 1 > k){
            count--;
            left++;
        }
        count++;
        max = Math.max(max, count);
        right++;
    }
    return max;
    
};

    