package main.java.Medium; /**https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/ */
//Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
//A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

class TreeNode59 {
      int val;
      TreeNode59 left;
      TreeNode59 right;
      TreeNode59() {}
      TreeNode59(int val) { this.val = val; }
      TreeNode59(int val, TreeNode59 left, TreeNode59 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode59 root) {
        return dfs(root, root.val, root.val);
        
        
    }
    public int dfs(TreeNode59 root, int max, int min){
        if(root == null){
            return max - min;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        return Math.max(dfs(root.left, max, min), dfs(root.right, max, min));
    
    }
}

    