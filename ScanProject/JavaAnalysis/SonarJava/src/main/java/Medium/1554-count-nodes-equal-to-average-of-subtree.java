package main.java.Medium; /**https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/ */
//Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
//Note:
//The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
//A subtree of root is a tree consisting of root and all of its descendants.

class TreeNode90 {
      int val;
      TreeNode90 left;
      TreeNode90 right;
      TreeNode90() {}
      TreeNode90(int val) { this.val = val; }
      TreeNode90(int val, TreeNode90 left, TreeNode90 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class CountNodesEqualToAverageOfSubtree {
    public int averageOfSubtree(TreeNode90 root) {
        int[] result = new int[1];
        averageOfSubtree(root, result);
        return result[0];
        
    }
    public int[] averageOfSubtree(TreeNode90 root, int[] result){
        if(root == null){
            return new int[]{0, 0};
        }
        int[] left = averageOfSubtree(root.left, result);
        int[] right = averageOfSubtree(root.right, result);
        int sum = root.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];
        if(sum / count == root.val){
            result[0]++;
        }
        return new int[]{sum, count};
    }
}
     
    