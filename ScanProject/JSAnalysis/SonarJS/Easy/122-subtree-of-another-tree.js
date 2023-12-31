/**https://leetcode.com/problems/subtree-of-another-tree/ */
//Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
//A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.


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
 * @param {TreeNode} subRoot
 * @return {boolean}
 */
var isSubtree = function(root, subRoot) {
    if(root == null){
        return false;
    }
    if(isSameTree(root, subRoot)){
        return true;
    }
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    
    
};
function isSameTree(root, subRoot){
    if(root == null && subRoot == null){
        return true;
    }
    if(root == null || subRoot == null){
        return false;
    }
    return (root.val == subRoot.val) && isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
}

    