package main.java.Medium; /**https://leetcode.com/problems/trim-a-binary-search-tree/ */
//Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.
//Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.


class TreeNode112 {
      int val;
      TreeNode112 left;
      TreeNode112 right;
      TreeNode112() {}
      TreeNode112(int val) { this.val = val; }
      TreeNode112(int val, TreeNode112 left, TreeNode112 right) {
          this.val = val;
         this.left = left;
          this.right = right;
      }
  }

class TrimABinarySearchTree {
    public TreeNode112 trimBST(TreeNode112 root, int low, int high) {
        if(root == null){
            return null;
        }
        if(root.val < low){
            return trimBST(root.right, low, high);
        }
        if(root.val > high){
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
        
    }
}

    