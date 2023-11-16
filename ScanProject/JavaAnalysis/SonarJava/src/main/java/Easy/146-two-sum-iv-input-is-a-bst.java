package main.java.Easy; /**https://leetcode.com/problems/two-sum-iv-input-is-a-bst/ */
//Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

import java.util.HashSet;
import java.util.Set;


class TreeNode18 {
      int val;
      TreeNode18 left;
      TreeNode18 right;
      TreeNode18() {}
      TreeNode18(int val) { this.val = val; }
      TreeNode18(int val, TreeNode18 left, TreeNode18 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class TwoSumIvInputIsABst {
    public boolean findTarget(TreeNode18 root, int k) {
        if(root == null) return false;
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }
    private boolean dfs(TreeNode18 root, int k, Set<Integer> set){
        if(root == null) return false;
        if(set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }
}

    