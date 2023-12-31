package main.java.Medium; /**https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/ */
//You are given the root of a binary search tree and an array queries of size n consisting of positive integers.
//Find a 2D array answer of size n where answer[i] = [mini, maxi]:
//mini is the largest value in the tree that is smaller than or equal to queries[i]. If a such value does not exist, add -1 instead.
//maxi is the smallest value in the tree that is greater than or equal to queries[i]. If a such value does not exist, add -1 instead.
//Return the array answer.


import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;


class TreeNode94 {
      int val;
      TreeNode94 left;
      TreeNode94 right;
      TreeNode94() {}
      TreeNode94(int val) { this.val = val; }
      TreeNode94(int val, TreeNode94 left, TreeNode94 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class ClosestNodesQueriesInABinarySearchTree {
    public List<List<Integer>> closestNodes(TreeNode94 root, List<Integer> queries) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < queries.size(); i++){
            int min = Integer.MIN_VALUE;
            int max = Integer.MAX_VALUE;
            TreeNode94 node = root;
            while(node != null){
                if(node.val == queries.get(i)){
                    min = node.val;
                    max = node.val;
                    break;
                }
                else if(node.val > queries.get(i)){
                    max = node.val;
                    node = node.left;
                }
                else{
                    min = node.val;
                    node = node.right;
                }
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(min);
            temp.add(max);
            list.add(temp);
        }
        return list;
        
        
    }
}

    