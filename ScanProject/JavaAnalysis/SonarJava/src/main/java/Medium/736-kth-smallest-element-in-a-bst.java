package main.java.Medium; /**https://leetcode.com/problems/kth-smallest-element-in-a-bst/ */
//Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

class TreeNode98 {
     int val;
      TreeNode98 left;
      TreeNode98 right;
      TreeNode98() {}
      TreeNode98(int val) { this.val = val; }
      TreeNode98(int val, TreeNode98 left, TreeNode98 right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class KthSmallestElementInABst {
    public int kthSmallest(TreeNode98 root, int k) {
        int left = countNodes(root.left);
        if(left == k - 1){
            return root.val;
        }else if(left > k - 1){
            return kthSmallest(root.left, k);
        }else{
            return kthSmallest(root.right, k - left - 1);
        }
        
        
    }
    private int countNodes(TreeNode98 root){
        if(root == null){
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

    