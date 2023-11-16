package main.java.Medium; /**https://leetcode.com/problems/all-possible-full-binary-trees/ */
//Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.
//Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.
//A full binary tree is a binary tree where each node has exactly 0 or 2 children.


import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;


class TreeNode52 {
      int val;
      TreeNode52 left;
      TreeNode52 right;
      TreeNode52() {}
      TreeNode52(int val) { this.val = val; }
      TreeNode52(int val, TreeNode52 left, TreeNode52 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class AllPossibleFullBinaryTrees {
    public List<TreeNode52> allPossibleFBT(int n) {
        List<TreeNode52> res = new ArrayList<>();
        if(n % 2 == 0){
            return res;
        }
        if(n == 1){
            res.add(new TreeNode52(0));
            return res;
        }
        for(int i = 1; i < n; i += 2){
            List<TreeNode52> left = allPossibleFBT(i);
            List<TreeNode52> right = allPossibleFBT(n - i - 1);
            for(TreeNode52 l : left){
                for(TreeNode52 r : right){
                    TreeNode52 root = new TreeNode52(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
        
        
    }
}

    