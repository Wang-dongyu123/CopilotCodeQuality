package main.java.Medium; /**https://leetcode.com/problems/recover-binary-search-tree/ */
//You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

class TreeNode82 {
      int val;
      TreeNode82 left;
      TreeNode82 right;
      TreeNode82() {}
      TreeNode82(int val) { this.val = val; }
      TreeNode82(int val, TreeNode82 left, TreeNode82 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class RecoverBinarySearchTree {
    public void recoverTree(TreeNode82 root) {
        TreeNode82[] nodes = new TreeNode82[2];
        TreeNode82[] prev = new TreeNode82[1];
        helper(root, nodes, prev);
        int temp = nodes[0].val;
        nodes[0].val = nodes[1].val;
        nodes[1].val = temp;
        
        
    }
    private void helper(TreeNode82 root, TreeNode82[] nodes, TreeNode82[] prev){
        if(root == null){
            return;
        }
        helper(root.left, nodes, prev);
        if(prev[0] != null && prev[0].val > root.val){
            nodes[1] = root;
            if(nodes[0] == null){
                nodes[0] = prev[0];
            }
            else{
                return;
            }
        }
        prev[0] = root;
        helper(root.right, nodes, prev);
    }
}

    