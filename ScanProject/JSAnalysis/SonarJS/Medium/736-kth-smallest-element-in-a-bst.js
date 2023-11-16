/**https://leetcode.com/problems/kth-smallest-element-in-a-bst/ */
//Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.


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
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(root, k) {
    let result = [];
    kthSmallestHelper(root, result);
    return result[k - 1];
    
    
    
};
function kthSmallestHelper(root, result){
    if(root == null){
        return;
    }
    kthSmallestHelper(root.left, result);
    result.push(root.val);
    kthSmallestHelper(root.right, result);
}

    