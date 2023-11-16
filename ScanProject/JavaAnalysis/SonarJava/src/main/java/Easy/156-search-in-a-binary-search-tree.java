package main.java.Easy; /**https://leetcode.com/problems/search-in-a-binary-search-tree/ */
//You are given the root of a binary search tree (BST) and an integer val.
//Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.


class TreeNode20 {
      int val;
      TreeNode20 left;
      TreeNode20 right;
      TreeNode20() {}
      TreeNode20(int val) { this.val = val; }
      TreeNode20(int val, TreeNode20 left, TreeNode20 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class SearchInABinarySearchTree {
    public TreeNode20 searchBST(TreeNode20 root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);
        
        
    }
}

    