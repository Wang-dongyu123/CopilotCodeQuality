package main.java.Medium; /**https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/ */
//Given the root of a binary tree, the depth of each node is the shortest distance to the root.
//Return the smallest subtree such that it contains all the deepest nodes in the original tree.
//A node is called the deepest if it has the largest depth possible among any node in the entire tree.
//The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.

class TreeNode25 {
      int val;
      TreeNode25 left;
      TreeNode25 right;
      TreeNode25() {}
      TreeNode25(int val) { this.val = val; }
      TreeNode25(int val, TreeNode25 left, TreeNode25 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class SmallestSubtreeWithAllTheDeepestNodes {
    public TreeNode25 subtreeWithAllDeepest(TreeNode25 root) {
        if(root == null){
            return null;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if(left == right){
            return root;
        }else if(left > right){
            return subtreeWithAllDeepest(root.left);
        }else{
            return subtreeWithAllDeepest(root.right);
        }

    }
    public int depth(TreeNode25 root){
        if(root == null){
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}

    