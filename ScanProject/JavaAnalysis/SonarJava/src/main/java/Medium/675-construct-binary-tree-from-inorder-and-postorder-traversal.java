package main.java.Medium; /**https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/ */
//Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

import javax.swing.tree.TreeNode;


 class TreeNode86 {
      int val;
      TreeNode86 left;
     TreeNode86 right;
      TreeNode86() {}
      TreeNode86(int val) { this.val = val; }
      TreeNode86(int val, TreeNode86 left, TreeNode86 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode86 buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0){
            return null;
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        
        
    }
    private TreeNode86 helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd){
            return null;
        }
        TreeNode86 root = new TreeNode86(postorder[postEnd]);
        int index = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == root.val){
                index = i;
            }
        }
        root.left = helper(inorder, postorder, inStart, index - 1, postStart, postStart + index - inStart - 1);
        root.right = helper(inorder, postorder, index + 1, inEnd, postStart + index - inStart, postEnd - 1);
        return root;
    }
}

    