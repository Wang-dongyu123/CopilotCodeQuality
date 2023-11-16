/**https://leetcode.com/problems/permutations-ii/ */
//Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.


/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
    let result = [];
    if(nums.length == 0){
        return result;
    }
    nums.sort((a, b) => a - b);
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
        if(visited[i]){
            continue;
        }
        if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]){
            continue;
        }
        current.push(nums[i]);
        visited[i] = true;
        helper(nums, current, result, visited);
        current.pop();
        visited[i] = false;
    }
}

    