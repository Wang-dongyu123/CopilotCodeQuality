package main.java.Easy; /**https://leetcode.com/problems/sum-of-left-leaves/ */
//Given the root of a binary tree, return the sum of all left leaves.
//A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.


class TreeNode36 {
      int val;
      TreeNode36 left;
      TreeNode36 right;
      TreeNode36() {}
      TreeNode36(int val) { this.val = val; }
      TreeNode36(int val, TreeNode36 left, TreeNode36 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode36 root) {
        if(root == null) return 0;
        int sum = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
        
    }
}

    