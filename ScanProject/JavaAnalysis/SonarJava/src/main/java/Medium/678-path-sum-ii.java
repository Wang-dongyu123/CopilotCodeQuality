package main.java.Medium; /**https://leetcode.com/problems/path-sum-ii/ */
//Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
//A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

import java.util.ArrayList;
import java.util.List;


 class TreeNode89 {
      int val;
      TreeNode89 left;
      TreeNode89 right;
      TreeNode89() {}
      TreeNode89(int val) { this.val = val; }
      TreeNode89(int val, TreeNode89 left, TreeNode89 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class PathSumIi {
    public List<List<Integer>> pathSum(TreeNode89 root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        helper(root, targetSum, new ArrayList<>(), result);
        return result;
        
    }
    private void helper(TreeNode89 root, int targetSum, List<Integer> list, List<List<Integer>> result){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum){
            result.add(new ArrayList<>(list));
        }
        helper(root.left, targetSum - root.val, list, result);
        helper(root.right, targetSum - root.val, list, result);
        list.remove(list.size() - 1);
    }
}

    