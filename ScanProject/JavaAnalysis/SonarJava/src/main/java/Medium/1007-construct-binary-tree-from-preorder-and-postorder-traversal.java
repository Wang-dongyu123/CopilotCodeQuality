package main.java.Medium; /**https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/ */
//Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.
//If there exist multiple answers, you can return any of them.

import javax.swing.tree.TreeNode;


class TreeNode51 {
      int val;
      TreeNode51 left;
      TreeNode51 right;
      TreeNode51() {}
      TreeNode51(int val) { this.val = val; }
      TreeNode51(int val, TreeNode51 left, TreeNode51 right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
  }

class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode51 constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        
    }
    public TreeNode51 construct(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if(preStart > preEnd){
            return null;
        }
        TreeNode51 root = new TreeNode51(preorder[preStart]);
        if(preStart == preEnd){
            return root;
        }
        int index = postStart;
        while(postorder[index] != preorder[preStart + 1]){
            index++;
        }
        int leftLen = index - postStart + 1;
        root.left = construct(preorder, preStart + 1, preStart + leftLen, postorder, postStart, index);
        root.right = construct(preorder, preStart + leftLen + 1, preEnd, postorder, index + 1, postEnd - 1);
        return root;
    }
}

    