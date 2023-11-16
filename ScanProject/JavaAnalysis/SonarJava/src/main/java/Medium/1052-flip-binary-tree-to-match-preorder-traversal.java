package main.java.Medium; /**https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/ */
//You are given the root of a binary tree with n nodes, where each node is uniquely assigned a value from 1 to n. You are also given a sequence of n values voyage, which is the desired pre-order traversal of the binary tree.
//Any node in the binary tree can be flipped by swapping its left and right subtrees. For example, flipping node 1 will have the following effect:
//Flip the smallest number of nodes so that the pre-order traversal of the tree matches voyage.
//Return a list of the values of all flipped nodes. You may return the answer in any order. If it is impossible to flip the nodes in the tree to make the pre-order traversal match voyage, return the list [-1].

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;


 class TreeNode55 {
      int val;
      TreeNode55 left;
      TreeNode55 right;
      TreeNode55() {}
      TreeNode55(int val) { this.val = val; }
      TreeNode55(int val, TreeNode55 left, TreeNode55 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class FlipBinaryTreeToMatchPreorderTraversal {
    public List<Integer> flipMatchVoyage(TreeNode55 root, int[] voyage) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        if(root.val != voyage[0]){
            result.add(-1);
            return result;
        }
        int[] index = new int[1];
        index[0] = 1;
        return dfs(root, voyage, index, result);
        
    }
    public List<Integer> dfs(TreeNode55 root, int[] voyage, int[] index, List<Integer> result){
        if(root == null){
            return result;
        }
        if(root.left != null && root.left.val != voyage[index[0]]){
            result.add(root.val);
            TreeNode55 temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        if(root.left != null && root.left.val == voyage[index[0]]){
            index[0]++;
            dfs(root.left, voyage, index, result);
        }
        if(root.right != null && root.right.val == voyage[index[0]]){
            index[0]++;
            dfs(root.right, voyage, index, result);
        }
        return result;
    }
}

    