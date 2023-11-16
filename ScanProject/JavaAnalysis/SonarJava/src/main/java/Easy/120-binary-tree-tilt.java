package main.java.Easy; /**https://leetcode.com/problems/binary-tree-tilt/ */
//Given the root of a binary tree, return the sum of every tree node's tilt.
//The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values. If a node does not have a left child, then the sum of the left subtree node values is treated as 0. The rule is similar if the node does not have a right child.

class TreeNode10 {
      int val;
      TreeNode10 left;
      TreeNode10 right;
      TreeNode10() {}
      TreeNode10(int val) { this.val = val; }
      TreeNode10(int val, TreeNode10 left, TreeNode10 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class BinaryTreeTilt {
    public int findTilt(TreeNode10 root) {
        if(root == null) return 0;
        int[] ans = new int[1];
        dfs(root, ans);
        return ans[0];
        
        
    }
    private int dfs(TreeNode10 root, int[] ans){
        if(root == null) return 0;
        int left = dfs(root.left, ans);
        int right = dfs(root.right, ans);
        ans[0] += Math.abs(left - right);
        return left + right + root.val;
    }
}

    