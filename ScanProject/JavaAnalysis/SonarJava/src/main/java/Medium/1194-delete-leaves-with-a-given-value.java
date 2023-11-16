package main.java.Medium; /**https://leetcode.com/problems/delete-leaves-with-a-given-value/ */
//Given a binary tree root and an integer target, delete all the leaf nodes with value target.
//Note that once you delete a leaf node with value target, if its parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you cannot).


class TreeNode69 {
      int val;
      TreeNode69 left;
      TreeNode69 right;
      TreeNode69() {}
      TreeNode69(int val) { this.val = val; }
      TreeNode69(int val, TreeNode69 left, TreeNode69 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class DeleteLeavesWithAGivenValue {
    public TreeNode69 removeLeafNodes(TreeNode69 root, int target) {
        if(root == null){
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if(root.left == null && root.right == null && root.val == target){
            return null;
        }
        return root;
        
    }
}

    