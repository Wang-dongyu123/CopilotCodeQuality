package main.java.Easy; /**https://leetcode.com/problems/maximum-depth-of-binary-tree/ */
//Given the root of a binary tree, return its maximum depth.
//A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


class TreeNode26 {
      int val;
      TreeNode26 left;
      TreeNode26 right;
      TreeNode26() {}
      TreeNode26(int val) { this.val = val; }
      TreeNode26(int val, TreeNode26 left, TreeNode26 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode26 root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        
        
    }
}

    