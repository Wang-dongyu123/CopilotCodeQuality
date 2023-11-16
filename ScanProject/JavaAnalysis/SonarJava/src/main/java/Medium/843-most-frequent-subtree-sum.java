package main.java.Medium; /**https://leetcode.com/problems/most-frequent-subtree-sum/ */
//Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.
//The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
// 
//Example 1:
//Input: root = [5,2,-3]
//Output: [2,-3,4]
//Example 2:
//Input: root = [5,2,-5]
//Output: [2]
// 
//Constraints:
//	The number of nodes in the tree is in the range [1, 104].
//	-105 <= Node.val <= 105

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class TreeNode104 {
      int val;
      TreeNode104 left;
      TreeNode104 right;
      TreeNode104() {}
      TreeNode104(int val) { this.val = val; }
      TreeNode104(int val, TreeNode104 left, TreeNode104 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution501 {
    public int[] findFrequentTreeSum(TreeNode104 root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        int[] result = new int[list.size()];
        int index = 0;
        for (int num : list) {
            result[index++] = num;
        }
        return result;
    }
    private int helper(TreeNode104 root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, map);
        int right = helper(root.right, map);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}