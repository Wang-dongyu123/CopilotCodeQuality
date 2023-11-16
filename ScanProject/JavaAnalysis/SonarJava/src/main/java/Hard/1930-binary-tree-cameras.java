package main.java.Hard; /**https://leetcode.com/problems/binary-tree-cameras/ */
//You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
//Return the minimum number of cameras needed to monitor all nodes of the tree.

class TreeNode45 {
      int val;
      TreeNode45 left;
      TreeNode45 right;
      TreeNode45() {}
      TreeNode45(int val) { this.val = val; }
      TreeNode45(int val, TreeNode45 left, TreeNode45 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class BinaryTreeCameras {

    public int minCameraCover(TreeNode45 root) {
        
        
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        minCameraCover(root, min);
        return min[0];
        
        
    }
    public int minCameraCover(TreeNode45 root, int[] min) {
        if(root == null){
            return 0;
        }
        int left = minCameraCover(root.left, min);
        int right = minCameraCover(root.right, min);
        if(left == 0 && right == 0){
            return 3;
        }
        if(left == 3 || right == 3){
            min[0]++;
            return 1;
        }
        if(left == 1 || right == 1){
            return 2;
        }
        return 3;
        
    }
}
     
    