/**https://leetcode.com/problems/permutations/ */
//Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.


/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    let result = [];
    if(nums.length == 0){
        return result;
    }
    let current = [];
    let visited = new Array(nums.length);
    helper(nums, current, result, visited);
    return result;
    
    
};
function helper(nums, current, result, visited){
    if(current.length == nums.length){
        result.push([...current]);
        return;
    }
    for(let i = 0; i < nums.length; i++){
        if(!visited[i]){
            current.push(nums[i]);
            visited[i] = true;
            helper(nums, current, result, visited);
            current.pop();
            visited[i] = false;
        }
    }
}

    