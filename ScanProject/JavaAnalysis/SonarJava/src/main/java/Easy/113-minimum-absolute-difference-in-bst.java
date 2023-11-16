package main.java.Easy; /**https://leetcode.com/problems/minimum-absolute-difference-in-bst/ */
//Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

import java.util.ArrayList;
import java.util.List;


class TreeNode8 {
      int val;
      TreeNode8 left;
      TreeNode8 right;
      TreeNode8() {}
      TreeNode8(int val) { this.val = val; }
      TreeNode8(int val, TreeNode8 left, TreeNode8 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class MinimumAbsoluteDifferenceInBst {
    public int getMinimumDifference(TreeNode8 root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.size() - 1; i++){
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        return min;
        
        
    }
    private void inorder(TreeNode8 root, List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

    