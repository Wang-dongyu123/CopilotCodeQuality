package main.java.Easy; /**https://leetcode.com/problems/balanced-binary-tree/ */
//Given a binary tree, determine if it is height-balanced.

class TreeNode28 {
      int val;
      TreeNode28 left;
      TreeNode28 right;
      TreeNode28() {}
      TreeNode28(int val) { this.val = val; }
      TreeNode28(int val, TreeNode28 left, TreeNode28 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class BalancedBinaryTree {
    public boolean isBalanced(TreeNode28 root) {
        return helper(root) != -1;
        
        
    }
    private int helper(TreeNode28 root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        if(left == -1){
            return -1;
        }
        int right = helper(root.right);
        if(right == -1){
            return -1;
        }
        if(Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
        
    }
}

    