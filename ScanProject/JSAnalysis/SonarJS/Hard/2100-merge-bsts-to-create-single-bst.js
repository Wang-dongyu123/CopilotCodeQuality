/**https://leetcode.com/problems/merge-bsts-to-create-single-bst/ */
//You are given n BST (binary search tree) root nodes for n separate BSTs stored in an array trees (0-indexed). Each BST in trees has at most 3 nodes, and no two roots have the same value. In one operation, you can:
//Select two distinct indices i and j such that the value stored at one of the leaves of trees[i] is equal to the root value of trees[j].
//Replace the leaf node in trees[i] with trees[j].
//Remove trees[j] from trees.
//Return the root of the resulting BST if it is possible to form a valid BST after performing n - 1 operations, or null if it is impossible to create a valid BST.
//A BST (binary search tree) is a binary tree where each node satisfies the following property:
//Every node in the node's left subtree has a value strictly less than the node's value.
//Every node in the node's right subtree has a value strictly greater than the node's value.
//A leaf is a node that has no children.


/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode[]} trees
 * @return {TreeNode}
 */
var canMerge = function(trees) {
    let result = 0;
    let map = new Map();
    for (let i = 0; i < trees.length; i++) {
        for (let j = 0; j < trees.length; j++) {
            if (i != j) {
                let root = trees[j];
                let leaf = findLeaf(trees[i]);
                if (leaf != null && leaf.val == root.val) {
                    result++;
                }
            }
        }
    }
    return result;
    
    
};
function findLeaf(root) {
    if (root == null) {
        return null;
    }
    if (root.left == null && root.right == null) {
        return root;
    }
    let left = findLeaf(root.left);
    let right = findLeaf(root.right);
    if (left == null) {
        return right;
    }
    return left;
}

    