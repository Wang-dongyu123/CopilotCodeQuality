package main.java.Medium; /**https://leetcode.com/problems/check-completeness-of-a-binary-tree/ */
//Given the root of a binary tree, determine if it is a complete binary tree.
//In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.


import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;


class TreeNode54 {
      int val;
      TreeNode54 left;
      TreeNode54 right;
      TreeNode54() {}
     TreeNode54(int val) { this.val = val; }
      TreeNode54(int val, TreeNode54 left, TreeNode54 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode54 root) {
        Queue<TreeNode54> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        while(!q.isEmpty()){
            TreeNode54 node = q.poll();
            if(node == null){
                flag = true;
            }else{
                if(flag){
                    return false;
                }
                q.add(node.left);
                q.add(node.right);
            }
        }
        return true;
        
    }
}

    