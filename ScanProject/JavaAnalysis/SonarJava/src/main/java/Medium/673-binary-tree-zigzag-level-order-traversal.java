package main.java.Medium; /**https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/ */
//Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).


import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



class TreeNode84 {
     int val;
      TreeNode84 left;
      TreeNode84 right;
      TreeNode84() {}
      TreeNode84(int val) { this.val = val; }
      TreeNode84(int val, TreeNode84 left, TreeNode84 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode84 root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode84> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode84 node = queue.poll();
                if(leftToRight){
                    level.add(node.val);
                }else{
                    level.add(0, node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
        
        
        
    }
}

    