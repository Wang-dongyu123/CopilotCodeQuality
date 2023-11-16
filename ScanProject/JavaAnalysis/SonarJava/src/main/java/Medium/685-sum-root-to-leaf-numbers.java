package main.java.Medium; /**https://leetcode.com/problems/sum-root-to-leaf-numbers/ */
//You are given the root of a binary tree containing digits from 0 to 9 only.
//Each root-to-leaf path in the tree represents a number.
//For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
//Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
//A leaf node is a node with no children.

class TreeNode96 {
      int val;
      TreeNode96 left;
      TreeNode96 right;
      TreeNode96() {}
      TreeNode96(int val) { this.val = val; }
      TreeNode96(int val, TreeNode96 left, TreeNode96 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      } }

class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode96 root) {
        if(root == null){
            return 0;
        }
        return helper(root, 0);
        
        
    }
    private int helper(TreeNode96 root, int sum){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return sum * 10 + root.val;
        }
        return helper(root.left, sum * 10 + root.val) + helper(root.right, sum * 10 + root.val);
    
    }

}

    