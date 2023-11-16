package main.java.Medium; /**https://leetcode.com/problems/find-duplicate-subtrees/ */
//Given the root of a binary tree, return all duplicate subtrees.
//For each kind of duplicate subtrees, you only need to return the root node of any one of them.
//Two trees are duplicate if they have the same structure with the same node values.
// 
//Example 1:
//Input: root = [1,2,3,4,null,2,4,null,null,4]
//Output: [[2,4],[4]]
//Example 2:
//Input: root = [2,1,1]
//Output: [[1]]
//Example 3:
//Input: root = [2,2,2,3,null,3,null]
//Output: [[2,3],[3]]
// 
//Constraints:
//	The number of the nodes in the tree will be in the range [1, 5000]
//	-200 <= Node.val <= 200

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class TreeNode3 {
      int val;
      TreeNode3 left;
      TreeNode3 right;
      TreeNode3() {}
      TreeNode3(int val) { this.val = val; }
      TreeNode3(int val, TreeNode3 left, TreeNode3 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution543 {
    public List<TreeNode3> findDuplicateSubtrees(TreeNode3 root) {

        List<TreeNode3> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        helper(root, map, result);
        return result;
    }
    private String helper(TreeNode3 root, Map<String, Integer> map, List<TreeNode3> result) {
        if (root == null) {
            return "#";
        }
        String left = helper(root.left, map, result);
        String right = helper(root.right, map, result);
        String cur = root.val + "," + left + "," + right;
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        if (map.get(cur) == 2) {
            result.add(root);
        }
        return cur;
    }
}