package main.java.Medium; /**https://leetcode.com/problems/unique-binary-search-trees-ii/ */
//Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;


class TreeNode80 {
      int val;
      TreeNode80 left;
      TreeNode80 right;
      TreeNode80() {}
      TreeNode80(int val) { this.val = val; }
      TreeNode80(int val, TreeNode80 left, TreeNode80 right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }

class UniqueBinarySearchTreesIi {
    public List<TreeNode80> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return helper(1, n);
        
    }
    private List<TreeNode80> helper(int low, int high){
        List<TreeNode80> list = new ArrayList<>();
        if(low > high){
            list.add(null);
            return list;
        }
        for(int i = low; i <= high; i++){
            List<TreeNode80> left = helper(low, i - 1);
            List<TreeNode80> right = helper(i + 1, high);
            for(TreeNode80 l : left){
                for(TreeNode80 r : right){
                    TreeNode80 node = new TreeNode80(i);
                    node.left = l;
                    node.right = r;
                    list.add(node);
                }
            }
        }
        return list;
    }
}

    