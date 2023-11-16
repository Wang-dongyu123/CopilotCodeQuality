package main.java.Medium; /**https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/ */
//Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.


import javax.swing.tree.TreeNode;


class TreeNode85 {
      int val;
      TreeNode85 left;
      TreeNode85 right;
      TreeNode85() {}
      TreeNode85(int val) { this.val = val; }
      TreeNode85(int val, TreeNode85 left, TreeNode85 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode85 buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        
       
     
    }
    private TreeNode85 helper(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd){
        if(preBegin > preEnd){
            return null;
        }
        TreeNode85 root = new TreeNode85(preorder[preBegin]);
        int rootIndex = findRootIndex(inorder, inorder[preBegin], inBegin, inEnd);
        int leftTreeSize = rootIndex - inBegin;
        root.left = helper(preorder, inorder, preBegin + 1, preBegin + leftTreeSize, inBegin, rootIndex - 1);
        root.right = helper(preorder, inorder, preBegin + leftTreeSize + 1, preEnd, rootIndex + 1, inEnd);
        return root;
    }
    private int findRootIndex(int[] inorder, int rootVal, int begin, int end){
        for(int i = begin; i <= end; i++){
            if(inorder[i] == rootVal){
                return i;
            }
        }
        return -1;
    }
}

    