package main.java.Easy; /**https://leetcode.com/problems/binary-tree-postorder-traversal/ */
//Given the root of a binary tree, return the postorder traversal of its nodes' values.


import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


class TreeNode32 {
      int val;
      TreeNode32 left;
      TreeNode32 right;
      TreeNode32() {}
     TreeNode32(int val) { this.val = val; }
      TreeNode32(int val, TreeNode32 left, TreeNode32 right) {
          this.val = val;
         this.left = left;
          this.right = right;
     }
  }

class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode32 root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode32> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode32 node = stack.pop();
            res.add(node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        Collections.reverse(res);
        return res;
        
        
    }
}

    