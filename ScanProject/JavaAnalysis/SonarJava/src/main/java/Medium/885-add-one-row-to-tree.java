package main.java.Medium; /**https://leetcode.com/problems/add-one-row-to-tree/ */
//Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.
//Note that the root node is at depth 1.
//The adding rule is:
//	Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
//	cur's original left subtree should be the left subtree of the new left subtree root.
//	cur's original right subtree should be the right subtree of the new right subtree root.
//	If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
// 
//Example 1:
//Input: root = [4,2,6,3,1,5], val = 1, depth = 2
//Output: [4,1,1,2,null,null,6,3,1,5]
//Example 2:
//Input: root = [4,2,null,3,1], val = 1, depth = 3
//Output: [4,2,null,1,1,3,null,null,1]
// 
//Constraints:
//	The number of nodes in the tree is in the range [1, 104].
//	The depth of the tree is in the range [1, 104].
//	-100 <= Node.val <= 100
//	-105 <= val <= 105
//	1 <= depth <= the depth of tree + 1

import javax.swing.tree.TreeNode;


 class TreeNode107 {
      int val;
      TreeNode107 left;
      TreeNode107 right;
      TreeNode107() {}
      TreeNode107(int val) { this.val = val; }
      TreeNode107(int val, TreeNode107 left, TreeNode107 right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
  }

class Solution533 {
    public TreeNode107 addOneRow(TreeNode107 root, int val, int depth) {
        if (depth == 1) {
            TreeNode107 node = new TreeNode107(val);
            node.left = root;
            return node;
        }
        helper(root, val, depth, 1);
        return root;
    }
    private void helper(TreeNode107 root, int val, int depth, int curDepth) {
        if (root == null) {
            return;
        }
        if (curDepth == depth - 1) {
            TreeNode107 left = root.left;
            TreeNode107 right = root.right;
            root.left = new TreeNode107(val);
            root.right = new TreeNode107(val);
            root.left.left = left;
            root.right.right = right;
            return;
        }
        helper(root.left, val, depth, curDepth + 1);
        helper(root.right, val, depth, curDepth + 1);

    }
}