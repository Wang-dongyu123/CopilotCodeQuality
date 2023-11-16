package main.java.Medium; /**https://leetcode.com/problems/longest-univalue-path/ */
//Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
//The length of the path between two nodes is represented by the number of edges between them.

class TreeNode113 {
     int val;
      TreeNode113 left;
      TreeNode113 right;
      TreeNode113() {}
      TreeNode113(int val) { this.val = val; }
      TreeNode113(int val, TreeNode113 left, TreeNode113 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode113 root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
        
    }
    public int helper(TreeNode113 root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int leftPath = 0;
        int rightPath = 0;
        if (root.left != null && root.left.val == root.val) {
            leftPath = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightPath = right + 1;
        }
        res[0] = Math.max(res[0], leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}

    