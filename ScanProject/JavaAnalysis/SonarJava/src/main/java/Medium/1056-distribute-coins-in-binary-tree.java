package main.java.Medium; /**https://leetcode.com/problems/distribute-coins-in-binary-tree/ */
//You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n coins in total throughout the whole tree.
//In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.
//Return the minimum number of moves required to make every node have exactly one coin.

class TreeNode56 {
      int val;
      TreeNode56 left;
      TreeNode56 right;
      TreeNode56() {}
      TreeNode56(int val) { this.val = val; }
      TreeNode56(int val, TreeNode56 left, TreeNode56 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class DistributeCoinsInBinaryTree {
    public int distributeCoins(TreeNode56 root) {
        if(root == null){
            return 0;
        }
        int[] result = new int[1];
        dfs(root, result);
        return result[0];
        
    }
    public int dfs(TreeNode56 root, int[] result){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left, result);
        int right = dfs(root.right, result);
        result[0] += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}

    