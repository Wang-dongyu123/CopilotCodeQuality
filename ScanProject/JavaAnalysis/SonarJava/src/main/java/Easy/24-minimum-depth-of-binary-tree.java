package main.java.Easy; /**https://leetcode.com/problems/minimum-depth-of-binary-tree/ */
//Given a binary tree, find its minimum depth.
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//Note: A leaf is a node with no children.


class TreeNode29 {
      int val;
      TreeNode29 left;
      TreeNode29 right;
     TreeNode29() {}
      TreeNode29(int val) { this.val = val; }
      TreeNode29(int val, TreeNode29 left, TreeNode29 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode29 root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if(root.left != null){
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if(root.right != null){
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }
}

    