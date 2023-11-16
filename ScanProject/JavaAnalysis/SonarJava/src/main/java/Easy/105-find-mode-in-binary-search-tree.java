package main.java.Easy; /**https://leetcode.com/problems/find-mode-in-binary-search-tree/ */
//Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
//If the tree has more than one mode, return them in any order.
//Assume a BST is defined as follows:
//The left subtree of a node contains only nodes with keys less than or equal to the node's key.
//The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
//Both the left and right subtrees must also be binary search trees.


//import javax.swing.tree.TreeNode;

import javax.swing.tree.TreeNode;
import java.util.*;


class TreeNode7 {
      int val;
      TreeNode7 left;
      TreeNode7 right;
      TreeNode7() {}
      TreeNode7(int val) { this.val = val; }
      TreeNode7(int val, TreeNode7 left, TreeNode7 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class FindModeInBinarySearchTree {
    public int[] findMode(TreeNode7 root) {
        if(root == null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode7> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode7 node = queue.poll();
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        int max = 0;
        for(int key : map.keySet()){
            max = Math.max(max, map.get(key));
        }
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == max){
                list.add(key);
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
        
    }
}

    