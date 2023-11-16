/**https://leetcode.com/problems/chalkboard-xor-game/ */
//You are given an array of integers nums represents the numbers written on a chalkboard.
//Alice and Bob take turns erasing exactly one number from the chalkboard, with Alice starting first. If erasing a number causes the bitwise XOR of all the elements of the chalkboard to become 0, then that player loses. The bitwise XOR of one element is that element itself, and the bitwise XOR of no elements is 0.
//Also, if any player starts their turn with the bitwise XOR of all the elements of the chalkboard equal to 0, then that player wins.
//Return true if and only if Alice wins the game, assuming both players play optimally.


/**
 * @param {number[]} nums
 * @return {boolean}
 */
var xorGame = function(nums) {
    let xor = 0;
    for (let i = 0; i < nums.length; i++) {
        xor ^= nums[i];
    }
    return xor === 0 || nums.length % 2 === 0;
    
};

    