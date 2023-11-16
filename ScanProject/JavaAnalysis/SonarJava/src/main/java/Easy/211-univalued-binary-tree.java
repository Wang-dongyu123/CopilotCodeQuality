package main.java.Easy; /**https://leetcode.com/problems/univalued-binary-tree/ */
//A binary tree is uni-valued if every node in the tree has the same value.
//Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.
// 
//Example 1:
//Input: root = [1,1,1,1,1,null,1]
//Output: true
//Example 2:
//Input: root = [2,2,2,5,2]
//Output: false
// 
//Constraints:
//	The number of nodes in the tree is in the range [1, 100].
//	0 <= Node.val < 100

class TreeNode37 {
     int val;
     TreeNode37 left;
     TreeNode37 right;
      TreeNode37() {}
      TreeNode37(int val) { this.val = val; }
     TreeNode37(int val, TreeNode37 left, TreeNode37 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  class Solution55 {
    public boolean isUnivalTree(TreeNode37 root) {
        if(root == null) return true;
        if(root.left != null && root.val != root.left.val) return false;
        if(root.right != null && root.val != root.right.val) return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);

    }
}