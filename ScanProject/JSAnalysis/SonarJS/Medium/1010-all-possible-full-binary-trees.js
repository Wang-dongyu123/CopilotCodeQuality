/**https://leetcode.com/problems/all-possible-full-binary-trees/ */
//Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.
//Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.
//A full binary tree is a binary tree where each node has exactly 0 or 2 children.


/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number} n
 * @return {TreeNode[]}
 */
var allPossibleFBT = function(n) {
    if(n % 2 == 0){
        return [];
    }
    let map = {};
    return helper(n, map);
    
};

function helper(n, map){
    if(n == 1){
        return [new TreeNode(0)];
    }
    if(map[n]){
        return map[n];
    }
    let result = [];
    for(let i = 1; i < n; i += 2){
        let left = helper(i, map);
        let right = helper(n - i - 1, map);
        for(let j = 0; j < left.length; j++){
            for(let k = 0; k < right.length; k++){
                let root = new TreeNode(0);
                root.left = left[j];
                root.right = right[k];
                result.push(root);
            }
        }
    }
    map[n] = result;
    return result;
}