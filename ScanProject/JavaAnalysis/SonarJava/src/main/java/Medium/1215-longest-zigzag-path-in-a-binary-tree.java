package main.java.Medium; /**https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/ */
//You are given the root of a binary tree.
//A ZigZag path for a binary tree is defined as follow:
//Choose any node in the binary tree and a direction (right or left).
//If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
//Change the direction from right to left or from left to right.
//Repeat the second and third steps until you can't move in the tree.
//Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
//Return the longest ZigZag path contained in that tree.

class TreeNode71 {
      int val;
     TreeNode71 left;
      TreeNode71 right;
      TreeNode71() {}
      TreeNode71(int val) { this.val = val; }
      TreeNode71(int val, TreeNode71 left, TreeNode71 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class LongestZigzagPathInABinaryTree {
    public int longestZigZag(TreeNode71 root) {
        int[] max = new int[1];
        helper(root, max, true);
        return max[0];
        
    }
    public int helper(TreeNode71 root, int[] max, boolean isLeft){
        if(root == null){
            return -1;
        }
        int left = helper(root.left, max, true);
        int right = helper(root.right, max, false);
        max[0] = Math.max(max[0], Math.max(left, right) + 1);
        return isLeft ? right + 1 : left + 1;
    }
}

    