/**https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/ */
//You are given an integer array bloomDay, an integer m and an integer k.
//You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
//The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
//Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.


/**
 * @param {number[]} bloomDay
 * @param {number} m
 * @param {number} k
 * @return {number}
 */
var minDays = function(bloomDay, m, k) {
    if (m * k > bloomDay.length) {
        return -1;
    }
    let left = 1;
    let right = Math.max(...bloomDay);
    while (left < right) {
        let mid = Math.floor((left + right) / 2);
        if (canMake(bloomDay, m, k, mid)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
    
    
};
function canMake(bloomDay, m, k, day) {
    let bouquets = 0;
    let flowers = 0;
    for (let i = 0; i < bloomDay.length && bouquets < m; i++) {
        if (bloomDay[i] <= day) {
            flowers++;
            if (flowers == k) {
                bouquets++;
                flowers = 0;
            }
        } else {
            flowers = 0;
        }
    }
    return bouquets >= m;
}

    