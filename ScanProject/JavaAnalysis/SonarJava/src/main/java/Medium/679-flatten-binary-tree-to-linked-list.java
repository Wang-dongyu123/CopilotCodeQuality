package main.java.Medium; /**https://leetcode.com/problems/flatten-binary-tree-to-linked-list/ */
//Given the root of a binary tree, flatten the tree into a "linked list":
//The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
//The "linked list" should be in the same order as a pre-order traversal of the binary tree.

import javax.swing.tree.TreeNode;


class TreeNode88 {
      int val;
      TreeNode88 left;
      TreeNode88 right;
      TreeNode88() {}
      TreeNode88(int val) { this.val = val; }
      TreeNode88(int val, TreeNode88 left, TreeNode88 right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
  }

class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode88 root) {
        if(root == null){
            return;
        }
        helper(root);
    }
    private TreeNode88 helper(TreeNode88 root){
        if(root == null){
            return null;
        }
        TreeNode88 left = helper(root.left);
        TreeNode88 right = helper(root.right);
        if(left != null){
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if(right != null){
            return right;
        }
        if(left != null){
            return left;
        }
        return root;
    }
}

    