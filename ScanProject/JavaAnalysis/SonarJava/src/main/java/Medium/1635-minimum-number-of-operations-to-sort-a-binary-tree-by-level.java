package main.java.Medium; /**https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/ */
//You are given the root of a binary tree with unique values.
//In one operation, you can choose any two nodes at the same level and swap their values.
//Return the minimum number of operations needed to make the values at each level sorted in a strictly increasing order.
//The level of a node is the number of edges along the path between it and the root node.


import javax.swing.tree.TreeNode;
import java.util.*;


class TreeNode93 {
      int val;
      TreeNode93 left;
      TreeNode93 right;
      TreeNode93() {}
      TreeNode93(int val) { this.val = val; }
      TreeNode93(int val, TreeNode93 left, TreeNode93 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class MinimumNumberOfOperationsToSortABinaryTreeByLevel {
    public int minimumOperations(TreeNode93 root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode93> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode93 node = queue.poll();
                temp.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            list.add(temp);
        }
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            List<Integer> temp = list.get(i);
            Collections.sort(temp);
            for(int j = 0; j < temp.size(); j++){
                if(temp.get(j) != list.get(i).get(j)){
                    count++;
                }
            }
        }
        return count;
        
    }
}

    