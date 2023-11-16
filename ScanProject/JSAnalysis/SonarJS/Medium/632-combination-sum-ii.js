/**https://leetcode.com/problems/combination-sum-ii/ */
//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//Each number in candidates may only be used once in the combination.
//Note: The solution set must not contain duplicate combinations.


/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
    let result = [];
    if(candidates.length == 0){
        return result;
    }
    candidates.sort((a, b) => a - b);
    let current = [];
    helper(candidates, target, 0, current, result);
    return result;
    
    
};
function helper(candidates, target, index, current, result){
    if(target == 0){
        result.push([...current]);
        return;
    }
    if(target < 0){
        return;
    }
    for(let i = index; i < candidates.length; i++){
        if(i > index && candidates[i] == candidates[i - 1]){
            continue;
        }
        current.push(candidates[i]);
        helper(candidates, target - candidates[i], i + 1, current, result);
        current.pop();
    }
}

    