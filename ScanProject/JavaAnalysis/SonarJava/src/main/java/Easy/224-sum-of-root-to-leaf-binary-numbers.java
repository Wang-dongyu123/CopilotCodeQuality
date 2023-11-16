package main.java.Easy; /**https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/ */
//You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.
//	For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
//For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.
//The test cases are generated so that the answer fits in a 32-bits integer.
// 
//Example 1:
//Input: root = [1,0,1,0,1,0,1]
//Output: 22
//Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
//Example 2:
//Input: root = [0]
//Output: 0
// 
//Constraints:
//	The number of nodes in the tree is in the range [1, 1000].
//	Node.val is 0 or 1.

class TreeNode39 {
     int val;
	 TreeNode39 left;
      TreeNode39 right;
      TreeNode39() {}
     TreeNode39(int val) { this.val = val; }
      TreeNode39(int val, TreeNode39 left, TreeNode39 right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
  }

class Solution68 {
    public int sumRootToLeaf(TreeNode39 root) {
       return sumRootToLeaf(root, 0);
    }
    public int sumRootToLeaf(TreeNode39 root, int sum) {
		if(root == null) return 0;
		sum = sum * 2 + root.val;
		if(root.left == null && root.right == null) return sum;
		return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
	}

}