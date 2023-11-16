/**https://leetcode.com/problems/sum-root-to-leaf-numbers/ */
//You are given the root of a binary tree containing digits from 0 to 9 only.
//Each root-to-leaf path in the tree represents a number.
//For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
//Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
//A leaf node is a node with no children.


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
 * @return {number}
 */
var sumNumbers = function(root) {
    let result = 0;
    if(root == null){
        return result;
    }
    let currentPath = [];
    sumNumbersHelper(root, currentPath, result);
    return result;
    
    
};
function sumNumbersHelper(currentNode, currentPath, result){
    if(currentNode == null){
        return;
    }
    currentPath.push(currentNode.val);
    if(currentNode.left == null && currentNode.right == null){
        let currentPathSum = 0;
        let base = 1;
        for(let i = currentPath.length - 1; i >= 0; i--){
            currentPathSum += (currentPath[i] * base);
            base *= 10;
        }
        result += currentPathSum;
    }else{
        sumNumbersHelper(currentNode.left, currentPath, result);
        sumNumbersHelper(currentNode.right, currentPath, result);
    }
    currentPath.pop();
}

    