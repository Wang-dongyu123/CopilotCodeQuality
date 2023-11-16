package main.java.Easy; /**https://leetcode.com/problems/path-sum/ */
//Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
//A leaf is a node with no children.


class TreeNode30 {
      int val;
      TreeNode30 left;
      TreeNode30 right;
      TreeNode30() {}
      TreeNode30(int val) { this.val = val; }
      TreeNode30(int val, TreeNode30 left, TreeNode30 right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }

class PathSum {
    public boolean hasPathSum(TreeNode30 root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        
        
    }
}

    