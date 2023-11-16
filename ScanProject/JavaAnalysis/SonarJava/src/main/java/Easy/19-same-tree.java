package main.java.Easy; /**https://leetcode.com/problems/same-tree/ */
//Given the roots of two binary trees p and q, write a function to check if they are the same or not.
//Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.


class TreeNode14 {
      int val;
     TreeNode14 left;
      TreeNode14 right;
     TreeNode14() {}
     TreeNode14(int val) { this.val = val; }
      TreeNode14(int val, TreeNode14 left, TreeNode14 right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
 }

class SameTree {
    public boolean isSameTree(TreeNode14 p, TreeNode14 q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
}

    