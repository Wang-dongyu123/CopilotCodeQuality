package main.java.Medium; /**https://leetcode.com/problems/find-largest-value-in-each-tree-row/ */
//Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
// 
//Example 1:
//Input: root = [1,3,2,5,3,null,9]
//Output: [1,3,9]
//Example 2:
//Input: root = [1,2,3]
//Output: [1,3]
// 
//Constraints:
//	The number of nodes in the tree will be in the range [0, 104].
//	-231 <= Node.val <= 231 - 1

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


 class TreeNode106 {
      int val;
      TreeNode106 left;
      TreeNode106 right;
      TreeNode106() {}
      TreeNode106(int val) { this.val = val; }
      TreeNode106(int val, TreeNode106 left, TreeNode106 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution503 {
    public List<Integer> largestValues(TreeNode106 root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode106> q = new LinkedList<>();
        q.offer(root);
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            max = Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode106 node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    q.offer(node.left);
                } 
                if (node.right != null) {
                    q.offer(node.right);
                }
                size--;
            }
            result.add(max);
        }
        return result;
    }
}