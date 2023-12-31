/**https://leetcode.com/problems/combination-sum-iii/ */
//Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
//Only numbers 1 through 9 are used.
//Each number is used at most once.
//Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.


/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function(k, n) {
    let result = [];
    if(k == 0){
        return result;
    }
    let current = [];
    helper(k, n, 1, current, result);
    return result;
    
    
    
};
function helper(k, n, index, current, result){
    if(n == 0 && current.length == k){
        result.push([...current]);
        return;
    }
    if(n < 0){
        return;
    }
    for(let i = index; i <= 9; i++){
        if(i > index && i == i - 1){
            continue;
        }
        current.push(i);
        helper(k, n - i, i + 1, current, result);
        current.pop();
    }
}
    