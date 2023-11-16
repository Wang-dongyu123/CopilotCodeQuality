package main.java.Medium; /**https://leetcode.com/problems/flip-equivalent-binary-trees/ */
//For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.
//A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.
//Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false otherwise.


class TreeNode53 {
      int val;
      TreeNode53 left;
      TreeNode53 right;
      TreeNode53() {}
      TreeNode53(int val) { this.val = val; }
      TreeNode53(int val, TreeNode53 left, TreeNode53 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode53 root1, TreeNode53 root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
        
    }
}

    