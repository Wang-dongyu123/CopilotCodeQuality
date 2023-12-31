package main.java.Easy; /**https://leetcode.com/problems/minimum-distance-between-bst-nodes/ */
//Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
// 
//Example 1:
//Input: root = [4,2,6,1,3]
//Output: 1
//Example 2:
//Input: root = [1,0,48,null,null,12,49]
//Output: 1
// 
//Constraints:
//	The number of nodes in the tree is in the range [2, 100].
//	0 <= Node.val <= 105
// 
//Note: This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/

class TreeNode21 {
      int val;
      TreeNode21 left;
     TreeNode21 right;
      TreeNode21() {}
      TreeNode21(int val) { this.val = val; }
      TreeNode21(int val, TreeNode21 left, TreeNode21 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution18 {
    public int minDiffInBST(TreeNode21 root) {
        int[] prev = new int[]{Integer.MIN_VALUE};
		int[] min = new int[]{Integer.MAX_VALUE};
		dfs(root, prev, min);
		return min[0];
    }
    private void dfs(TreeNode21 root, int[] prev, int[] min) {
		if (root == null) {
			return;
		}
		dfs(root.left, prev, min);
		min[0] = Math.min(min[0], root.val - prev[0]);
		prev[0] = root.val;
		dfs(root.right, prev, min);
    }
}