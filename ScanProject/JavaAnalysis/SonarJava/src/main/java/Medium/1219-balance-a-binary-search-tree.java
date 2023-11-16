package main.java.Medium; /**https://leetcode.com/problems/balance-a-binary-search-tree/ */
//Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.
//A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

import java.util.ArrayList;
import java.util.List;


class TreeNode72 {
      int val;
      TreeNode72 left;
      TreeNode72 right;TreeNode72() {}
      TreeNode72(int val) { this.val = val; }
      TreeNode72(int val, TreeNode72 left, TreeNode72 right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }

class BalanceABinarySearchTree {
    public TreeNode72 balanceBST(TreeNode72 root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return buildTree(list, 0, list.size() - 1);
        
    }
    public TreeNode72 buildTree(List<Integer> list, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode72 node = new TreeNode72(list.get(mid));
        node.left = buildTree(list, start, mid - 1);
        node.right = buildTree(list, mid + 1, end);
        return node;
    }
    public void inorder(TreeNode72 root, List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

    