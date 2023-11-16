package main.java.Easy; /**https://leetcode.com/problems/symmetric-tree/ */
//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

class TreeNode15 {
     int val;
      TreeNode15 left;
      TreeNode15 right;
      TreeNode15() {}
     TreeNode15(int val) { this.val = val; }
      TreeNode15(int val, TreeNode15 left, TreeNode15 right) {
         this.val = val;
          this.left = left;
         this.right = right;
      }
 }

class SymmetricTree {
    public boolean isSymmetric(TreeNode15 root) {
        return isMirror(root, root);
        
    }
    private boolean isMirror(TreeNode15 root1, TreeNode15 root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 != null && root2 != null && root1.val == root2.val){
            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }
        return false;
    }
}

    