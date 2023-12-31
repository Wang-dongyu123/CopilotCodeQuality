/**https://leetcode.com/problems/lexicographical-numbers/ */
//Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
//You must write an algorithm that runs in O(n) time and uses O(1) extra space. 


/**
 * @param {number} n
 * @return {number[]}
 */
var lexicalOrder = function(n) {
    let result = [];
    for(let i = 1; i < 10; i++){
        dfs(i, n, result);
    }
    return result;
    
    
};
function dfs(i, n, result){
    if(i > n){
        return;
    }
    result.push(i);
    for(let j = 0; j < 10; j++){
        dfs(i * 10 + j, n, result);
    }
}
    