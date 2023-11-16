package main.java.Medium; /**https://leetcode.com/problems/validate-binary-search-tree/ */
//Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//A valid BST is defined as follows:
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.

class TreeNode81 {
      int val;
      TreeNode81 left;
      TreeNode81 right;
      TreeNode81() {}
      TreeNode81(int val) { this.val = val; }
      TreeNode81(int val, TreeNode81 left, TreeNode81 right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode81 root) {
        return helper(root, null, null);
        
         
        
    }
     private boolean helper(TreeNode81 root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        if(min != null && root.val <= min){
            return false;
        }
        if(max != null && root.val >= max){
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        
    }

}

    