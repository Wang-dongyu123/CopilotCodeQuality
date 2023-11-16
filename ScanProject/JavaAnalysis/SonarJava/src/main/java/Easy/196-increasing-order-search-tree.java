package main.java.Easy; /**https://leetcode.com/problems/increasing-order-search-tree/ */
//Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.
// 
//Example 1:
//Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
//Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//Example 2:
//Input: root = [5,1,7]
//Output: [1,null,5,null,7]
// 
//Constraints:
//	The number of nodes in the given tree will be in the range [1, 100].
//	0 <= Node.val <= 1000

import javax.swing.tree.TreeNode;
import java.util.Stack;


class TreeNode23 {
      int val;
      TreeNode23 left;
      TreeNode23 right;
      TreeNode23() {}
      TreeNode23(int val) { this.val = val; }
      TreeNode23(int val, TreeNode23 left, TreeNode23 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution41 {
    public TreeNode23 increasingBST(TreeNode23 root) {
        TreeNode23 dummy = new TreeNode23();
    	TreeNode23 cur = dummy;
    	Stack<TreeNode23> stack = new Stack<>();
    	while(root != null || !stack.isEmpty()){
    		while(root != null){
    			stack.push(root);
    			root = root.left;
    		}
    		root = stack.pop();
    		cur.right = root;
    		cur.left = null;
    		cur = cur.right;
    		root = root.right;
    	}
    	return dummy.right;
    }
}