/**https://leetcode.com/problems/subsets-ii/ */
//Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//The solution set must not contain duplicate subsets. Return the solution in any order.


/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    let result = [];
    if(nums.length == 0){
        return result;
    }
    nums.sort((a, b) => a - b);
    let current = [];
    helper(nums, 0, current, result);
    return result;
    
    
    
};
function helper(nums, index, current, result){
    result.push([...current]);
    for(let i = index; i < nums.length; i++){
        if(i > index && nums[i] == nums[i - 1]){
            continue;
        }
        current.push(nums[i]);
        helper(nums, i + 1, current, result);
        current.pop();
    }
}

    