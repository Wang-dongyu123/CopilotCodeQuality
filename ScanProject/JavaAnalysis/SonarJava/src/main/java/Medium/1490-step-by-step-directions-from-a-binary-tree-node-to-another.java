package main.java.Medium; /**https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/ */
//You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.
//Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:
//	'L' means to go from a node to its left child node.
//	'R' means to go from a node to its right child node.
//	'U' means to go from a node to its parent node.
//Return the step-by-step directions of the shortest path from node s to node t.
// 
//Example 1:
//Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
//Output: "UURL"
//Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
//Example 2:
//Input: root = [2,1], startValue = 2, destValue = 1
//Output: "L"
//Explanation: The shortest path is: 2 → 1.
// 
//Constraints:
//	The number of nodes in the tree is n.
//	2 <= n <= 105
//	1 <= Node.val <= n
//	All the values in the tree are unique.
//	1 <= startValue, destValue <= n
//	startValue != destValue

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;


class TreeNode77 {
      int val;
      TreeNode77 left;
      TreeNode77 right;
      TreeNode77() {}
      TreeNode77(int val) { this.val = val; }
      TreeNode77(int val, TreeNode77 left, TreeNode77 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution272 {
    public String getDirections(TreeNode77 root, int startValue, int destValue) {
        TreeNode77 start = find(root, startValue);
        TreeNode77 dest = find(root, destValue);
        List<Character> list = new ArrayList<>();
        while (start != dest) {
            if (start.val < dest.val) {
                start = start.right;
                list.add('R');
            } else {
                start = start.left;
                list.add('L');
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        int n = sb.length();
        for (int i = 0; i < n >> 1; i++) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(n - 1 - i));
            sb.setCharAt(n - 1 - i, temp);
        }
        return sb.toString();
    }
    private TreeNode77 find(TreeNode77 root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        TreeNode77 left = find(root.left, target);
        if (left != null) {
            return left;
        }
        TreeNode77 right = find(root.right, target);
        if (right != null) {
            return right;
        }
        return null;
    }
}