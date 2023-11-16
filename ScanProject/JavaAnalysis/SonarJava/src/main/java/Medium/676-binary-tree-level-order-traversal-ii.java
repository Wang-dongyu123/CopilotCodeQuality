package main.java.Medium; /**https://leetcode.com/problems/binary-tree-level-order-traversal-ii/ */
//Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).


import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


 class TreeNode87 {
      int val;
      TreeNode87 left;
           TreeNode87 right;
      TreeNode87() {}
      TreeNode87(int val) { this.val = val; }
      TreeNode87(int val, TreeNode87 left, TreeNode87 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class BinaryTreeLevelOrderTraversalIi {
    public List<List<Integer>> levelOrderBottom(TreeNode87 root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode87> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode87 node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(0, level);
        }
        return result;
        
        
        
    }
}

    