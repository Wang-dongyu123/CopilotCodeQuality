package main.java.Easy; /**https://leetcode.com/problems/cousins-in-binary-tree/ */
//Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
//Two nodes of a binary tree are cousins if they have the same depth with different parents.
//Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
// 
//Example 1:
//Input: root = [1,2,3,4], x = 4, y = 3
//Output: false
//Example 2:
//Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
//Output: true
//Example 3:
//Input: root = [1,2,3,null,4], x = 2, y = 3
//Output: false
// 
//Constraints:
//	The number of nodes in the tree is in the range [2, 100].
//	1 <= Node.val <= 100
//	Each node has a unique value.
//	x != y
//	x and y are exist in the tree.

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

 class TreeNode38 {
      int val;
      TreeNode38 left;
      TreeNode38 right;
      TreeNode38() {}
      TreeNode38(int val) { this.val = val; }
      TreeNode38(int val, TreeNode38 left, TreeNode38 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution59 {
    public boolean isCousins(TreeNode38 root, int x, int y) {
        Queue<TreeNode38> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int size = q.size();
			boolean foundX = false;
			boolean foundY = false;
			for(int i = 0; i < size; i++) {
				TreeNode38 cur = q.poll();
				if(cur.val == x) foundX = true;
				if(cur.val == y) foundY = true;
				if(cur.left != null && cur.right != null) {
					if(cur.left.val == x && cur.right.val == y) return false;
					if(cur.left.val == y && cur.right.val == x) return false;
				}
				if(cur.left != null) q.add(cur.left);
				if(cur.right != null) q.add(cur.right);
			}
			if(foundX && foundY) return true;
		}
		return false;
    }
}