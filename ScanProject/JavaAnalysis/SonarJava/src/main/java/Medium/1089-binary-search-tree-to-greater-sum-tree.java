package main.java.Medium; /**https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/ */
//Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
//As a reminder, a binary search tree is a tree that satisfies these constraints:
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.


import javax.swing.tree.TreeNode;
import java.util.Stack;


class TreeNode60 {
      int val;
      TreeNode60 left;
      TreeNode60 right;
      TreeNode60() {}
      TreeNode60(int val) { this.val = val; }
      TreeNode60(int val, TreeNode60 left, TreeNode60 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class BinarySearchTreeToGreaterSumTree {
    public TreeNode60 bstToGst(TreeNode60 root) {

        if(root == null){
            return null;
        }
        int sum = 0;
        Stack<TreeNode60> stack = new Stack<>();
        TreeNode60 node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;

        
    }
}

    