/**https://leetcode.com/problems/path-sum-ii/ */
//Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
//A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.


/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} targetSum
 * @return {number[][]}
 */
var pathSum = function(root, targetSum) {
    let result = [];
    if(root == null){
        return result;
    }
    let currentPath = [];
    pathSumHelper(root, targetSum, currentPath, result);
    return result;
    
    
};
function pathSumHelper(currentNode, targetSum, currentPath, result){
    if(currentNode == null){
        return;
    }
    currentPath.push(currentNode.val);
    if(currentNode.val == targetSum && currentNode.left == null && currentNode.right == null){
        result.push(currentPath.slice());
    }else{
        pathSumHelper(currentNode.left, targetSum - currentNode.val, currentPath, result);
        pathSumHelper(currentNode.right, targetSum - currentNode.val, currentPath, result);
    }
    currentPath.pop();
}

    