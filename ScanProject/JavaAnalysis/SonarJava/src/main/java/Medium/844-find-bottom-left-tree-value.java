package main.java.Medium; /**https://leetcode.com/problems/find-bottom-left-tree-value/ */
//Given the root of a binary tree, return the leftmost value in the last row of the tree.
// 
//Example 1:
//Input: root = [2,1,3]
//Output: 1
//Example 2:
//Input: root = [1,2,3,4,null,5,6,null,null,7]
//Output: 7
// 
//Constraints:
//	The number of nodes in the tree is in the range [1, 104].
//	-231 <= Node.val <= 231 - 1

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;


class TreeNode105 {
      int val;
      TreeNode105 left;
      TreeNode105 right;
      TreeNode105() {}
      TreeNode105(int val) { this.val = val; }
      TreeNode105(int val, TreeNode105 left, TreeNode105 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution502 {
    public int findBottomLeftValue(TreeNode105 root) {
        Queue<TreeNode105> q = new LinkedList<>();
        q.offer(root);
        int result = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            result = q.peek().val;
            while (size > 0) {
                TreeNode105 node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                } 
                if (node.right != null) {
                    q.offer(node.right);
                }
                size--;
            }
        }
        return result;
    }
}