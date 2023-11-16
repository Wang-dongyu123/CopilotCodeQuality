package main.java.Medium; /**https://leetcode.com/problems/binary-tree-pruning/ */
//Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
//A subtree of a node node is node plus every node that is a descendant of node.


class TreeNode115 {
      int val;
      TreeNode115 left;
      TreeNode115 right;
      TreeNode115() {}
      TreeNode115(int val) { this.val = val; }
      TreeNode115(int val, TreeNode115 left, TreeNode115 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class BinaryTreePruning {
    public TreeNode115 pruneTree(TreeNode115 root) {
        if(root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.val == 0 && root.left == null && root.right == null){
            return null;
        }
        return root;
        
    }
}

    