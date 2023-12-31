/**https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/ */
//Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
//Assume a BST is defined as follows:
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.


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
var maxSumBST = function(root) {
    let max = 0;
    let stack = [];
    let node = root;
    while(node != null || stack.length > 0){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        if(isBST(node)){
            max = Math.max(max, sum(node));
        }
        node = node.right;
    }
    return max;
    
};
function sum(root){
    if(root == null){
        return 0;
    }
    return root.val + sum(root.left) + sum(root.right);
}
function isBST(root){
    return isBSTUtil(root, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER);
}
function isBSTUtil(root, min, max){
    if(root == null){
        return true;
    }
    if(root.val <= min || root.val >= max){
        return false;
    }
    return isBSTUtil(root.left, min, root.val) && isBSTUtil(root.right, root.val,
        max);
}

    