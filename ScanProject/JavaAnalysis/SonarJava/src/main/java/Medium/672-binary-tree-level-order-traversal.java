package main.java.Medium; /**https://leetcode.com/problems/binary-tree-level-order-traversal/ */
//Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).


import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


 class TreeNode83 {
      int val;
      TreeNode83 left;
      TreeNode83 right;
      TreeNode83() {}
      TreeNode83(int val) { this.val = val; }
      TreeNode83(int val, TreeNode83 left, TreeNode83 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode83 root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode83> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode83 node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(level);
        }
        return result;
        
        
    }
}

    