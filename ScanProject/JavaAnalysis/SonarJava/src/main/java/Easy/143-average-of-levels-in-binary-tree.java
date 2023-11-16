package main.java.Easy; /**https://leetcode.com/problems/average-of-levels-in-binary-tree/ */
//Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.


import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode17 {
      int val;
      TreeNode17 left;
      TreeNode17 right;
      TreeNode17() {}
      TreeNode17(int val) { this.val = val; }
      TreeNode17(int val, TreeNode17 left, TreeNode17 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode17 root) {
        List<Double> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode17> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode17 node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(sum / size);
        }
        return res;
        
        
        
    }
}

    