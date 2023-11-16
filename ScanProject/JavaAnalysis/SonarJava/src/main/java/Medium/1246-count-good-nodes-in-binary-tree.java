package main.java.Medium; /**https://leetcode.com/problems/count-good-nodes-in-binary-tree/ */
//Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
//Return the number of good nodes in the binary tree.

class TreeNode73 {
      int val;
      TreeNode73 left;
      TreeNode73 right;
      TreeNode73() {}
      TreeNode73(int val) { this.val = val; }
      TreeNode73(int val, TreeNode73 left, TreeNode73 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode73 root) {
        return helper(root, Integer.MIN_VALUE);
        
    }
    public int helper(TreeNode73 root, int max){
        if(root == null){
            return 0;
        }
        int res = root.val >= max ? 1 : 0;
        max = Math.max(max, root.val);
        return res + helper(root.left, max) + helper(root.right, max);
    }
}

    