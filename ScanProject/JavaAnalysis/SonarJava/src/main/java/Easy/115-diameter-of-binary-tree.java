package main.java.Easy; /**https://leetcode.com/problems/diameter-of-binary-tree/ */
//Given the root of a binary tree, return the length of the diameter of the tree.
//The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//The length of a path between two nodes is represented by the number of edges between them.

class TreeNode9 {
      int val;
      TreeNode9 left;
      TreeNode9 right;
      TreeNode9() {}
      TreeNode9(int val) { this.val = val; }
      TreeNode9(int val, TreeNode9 left, TreeNode9 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode9 root) {
        if(root == null) return 0;
        int[] ans = new int[1];
        dfs(root, ans);
        return ans[0];
        
    }
    private int dfs(TreeNode9 root, int[] ans){
        if(root == null) return 0;
        int left = dfs(root.left, ans);
        int right = dfs(root.right, ans);
        ans[0] = Math.max(ans[0], left + right);
        return Math.max(left, right) + 1;
    }
}

    