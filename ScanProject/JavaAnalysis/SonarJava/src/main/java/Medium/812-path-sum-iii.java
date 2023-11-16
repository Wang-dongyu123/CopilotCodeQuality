package main.java.Medium; /**https://leetcode.com/problems/path-sum-iii/ */
//Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
//The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

class TreeNode102 {
      int val;
           TreeNode102 left;
      TreeNode102 right;
      TreeNode102() {}
      TreeNode102(int val) { this.val = val; }
      TreeNode102(int val, TreeNode102 left, TreeNode102 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class PathSumIii {
    public int pathSum(TreeNode102 root, int targetSum) {
        if(root == null){
            return 0;
        }
        return pathSumFrom(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        
    }
    private int pathSumFrom(TreeNode102 root, int targetSum){
        if(root == null){
            return 0;
        }
        return (root.val == targetSum ? 1 : 0) + pathSumFrom(root.left, targetSum - root.val) + pathSumFrom(root.right, targetSum - root.val);
    
    }
}

    