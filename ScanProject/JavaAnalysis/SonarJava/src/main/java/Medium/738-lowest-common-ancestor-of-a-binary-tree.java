package main.java.Medium; /**https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/ */
//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//According to the definition of LCA on Wikipedia: ��The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).��


import javax.swing.tree.TreeNode;


class TreeNode100 {
     int val;
      TreeNode100 left;
      TreeNode100 right;
     TreeNode100(int x) { val = x; }
  }

class LowestCommonAncestorOfABinaryTree {
    public TreeNode100 lowestCommonAncestor(TreeNode100 root, TreeNode100 p, TreeNode100 q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode100 left = lowestCommonAncestor(root.left, p, q);
        TreeNode100 right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;
        }else if(left != null){
            return left;
        }else{
            return right;
        }
        
    }
}

    