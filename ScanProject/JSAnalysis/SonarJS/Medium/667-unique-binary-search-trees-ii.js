/**https://leetcode.com/problems/unique-binary-search-trees-ii/ */
//Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.


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
var generateTrees = function(n) {
    if(n == 0){
        return [];
    }
    return generateTreesHelper(1, n);
    
    
};
function generateTreesHelper(start, end){
    let result = [];
    if(start > end){
        result.push(null);
        return result;
    }
    for(let i = start; i <= end; i++){
        let leftSubtrees = generateTreesHelper(start, i - 1);
        let rightSubtrees = generateTreesHelper(i + 1, end);
        for(let leftSubtree of leftSubtrees){
            for(let rightSubtree of rightSubtrees){
                let root = new TreeNode(i);
                root.left = leftSubtree;
                root.right = rightSubtree;
                result.push(root);
            }
        }
    }
    return result;
}

    