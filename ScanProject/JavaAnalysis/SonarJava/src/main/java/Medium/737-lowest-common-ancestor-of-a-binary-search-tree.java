package main.java.Medium; /**https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/ */
//Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
//According to the definition of LCA on Wikipedia: ��The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).��


class TreeNode99 {
 int val;
      TreeNode99 left;
      TreeNode99 right;
      TreeNode99(int x) { val = x; }
  }


class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode99 lowestCommonAncestor(TreeNode99 root, TreeNode99 p, TreeNode99 q) {
        if(root == null){
            return null;
        }
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
        
    }
}

    