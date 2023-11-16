package main.java.Easy; /**https://leetcode.com/problems/invert-binary-tree/ */
//Given the root of a binary tree, invert the tree, and return its root.


import javax.swing.tree.TreeNode;


class TreeNode34 {
      int val;
      TreeNode34 left;
     TreeNode34 right;
      TreeNode34() {}
     TreeNode34(int val) { this.val = val; }
      TreeNode34(int val, TreeNode34 left, TreeNode34 right) {
          this.val = val;
         this.left = left;
         this.right = right;
      }
  }

class InvertBinaryTree {
    public TreeNode34 invertTree(TreeNode34 root) {
        if(root == null) return null;
        TreeNode34 left = invertTree(root.left);
        TreeNode34 right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
        
    }
}

    