package main.java.Hard; /**https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/ */
//Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
//Assume a BST is defined as follows:
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.

class TreeNode48 {
      int val;
      TreeNode48 left;
      TreeNode48 right;
      TreeNode48() {}
      TreeNode48(int val) { this.val = val; }
      TreeNode48(int val, TreeNode48 left, TreeNode48 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class MaximumSumBstInBinaryTree {
    public int maxSumBST(TreeNode48 root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
        
        
    }
    public int[] dfs(TreeNode48 root, int[] res) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 1};
        }
        int[] left = dfs(root.left, res);
        int[] right = dfs(root.right, res);
        if (left[3] == 1 && right[3] == 1 && root.val > left[1] && root.val < right[0]) {
            res[0] = Math.max(res[0], left[2] + right[2] + root.val);
            return new int[]{Math.min(left[0], root.val), Math.max(right[1], root.val), left[2] + right[2] + root.val, 1};
        }
        return new int[]{0, 0, 0, 0};
    }
}
     
    