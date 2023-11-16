package main.java.Easy; /**https://leetcode.com/problems/binary-tree-paths/ */
//Given the root of a binary tree, return all root-to-leaf paths in any order.
//A leaf is a node with no children.
// 
//Example 1:
//Input: root = [1,2,3,null,5]
//Output: ["1->2->5","1->3"]
//Example 2:
//Input: root = [1]
//Output: ["1"]
// 
//Constraints:
//	The number of nodes in the tree is in the range [1, 100].
//	-100 <= Node.val <= 100

import java.util.ArrayList;
import java.util.List;


class TreeNode35 {
      int val;
      TreeNode35 left;
      TreeNode35 right;
     TreeNode35() {}
      TreeNode35(int val) { this.val = val; }
      TreeNode35(int val, TreeNode35 left, TreeNode35 right) {
         this.val = val;
         this.left = left;
          this.right = right;
     }
  }

class Solution387 {
    public List<String> binaryTreePaths(TreeNode35 root) {
        List<String> result = new ArrayList<>();
		if (root == null) return result;
		if (root.left == null && root.right == null) {
			result.add(String.valueOf(root.val));
			return result;
		}
		for (String path : binaryTreePaths(root.left)) {
			result.add(root.val + "->" + path);
		}
		for (String path : binaryTreePaths(root.right)) {
			result.add(root.val + "->" + path);
		}
		return result;
        
    }
}