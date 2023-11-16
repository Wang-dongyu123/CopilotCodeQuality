package main.java.Easy; /**https://leetcode.com/problems/binary-tree-inorder-traversal/ */
//Given the root of a binary tree, return the inorder traversal of its nodes' values.


import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class TreeNode13 {
      int val;
      TreeNode13 left;
     TreeNode13 right;
      TreeNode13() {}
      TreeNode13(int val) { this.val = val; }
      TreeNode13(int val, TreeNode13 left, TreeNode13 right) {
          this.val = val;
         this.left = left;
          this.right = right;
     }
  }

class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode13 root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode13> stack = new Stack<>();
        TreeNode13 cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
        
        
    }
}

    