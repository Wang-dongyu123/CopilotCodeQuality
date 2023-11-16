package main.java.Medium; /**https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/ */
//Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.
//Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.
//Note that you need to maximize the answer before taking the mod and not after taking it.

import java.util.LinkedList;
import java.util.Queue;


 class TreeNode70 {
      int val;
      TreeNode70 left;
      TreeNode70 right;
      TreeNode70() {}
      TreeNode70(int val) { this.val = val; }
      TreeNode70(int val, TreeNode70 left, TreeNode70 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class MaximumProductOfSplittedBinaryTree {
    public int maxProduct(TreeNode70 root) {
        int sum = sum(root);
        long max = 0;
        Queue<TreeNode70> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode70 node = queue.poll();
                long left = sum - node.val;
                long right = node.val;
                max = Math.max(max, left * right);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return (int)(max % 1000000007);
        
        
    }
    public int sum(TreeNode70 root){
        if(root == null){
            return 0;
        }
        return sum(root.left) + sum(root.right) + root.val;
    }
}

    