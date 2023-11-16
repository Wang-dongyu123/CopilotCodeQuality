package main.java.Easy; /**https://leetcode.com/problems/binary-tree-preorder-traversal/ */
//Given the root of a binary tree, return the preorder traversal of its nodes' values.


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


 class TreeNode31 {
      int val;
      TreeNode31 left;
      TreeNode31 right;
      TreeNode31() {}
      TreeNode31(int val) { this.val = val; }
      TreeNode31(int val, TreeNode31 left, TreeNode31 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode31 root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode31> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode31 node = stack.pop();
            res.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return res;
        
    }
}

    