package main.java.Medium; /**https://leetcode.com/problems/deepest-leaves-sum/ */
//Given the root of a binary tree, return the sum of values of its deepest leaves.


import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;


class TreeNode66 {
      int val;
      TreeNode66 left;
     TreeNode66 right;
      TreeNode66() {}
      TreeNode66(int val) { this.val = val; }
      TreeNode66(int val, TreeNode66 left, TreeNode66 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode66 root) {
        int sum = 0;
        Queue<TreeNode66> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode66 node = queue.poll();
                sum += node.val;
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return sum;
        
    }
}

    