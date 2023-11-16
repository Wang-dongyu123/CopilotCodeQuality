package main.java.Medium; /**https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/ */
//You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
//Each minute, a node becomes infected if:
//	The node is currently uninfected.
//	The node is adjacent to an infected node.
//Return the number of minutes needed for the entire tree to be infected.
// 
//Example 1:
//Input: root = [1,5,3,null,4,10,6,9,2], start = 3
//Output: 4
//Explanation: The following nodes are infected during:
//- Minute 0: Node 3
//- Minute 1: Nodes 1, 10 and 6
//- Minute 2: Node 5
//- Minute 3: Node 4
//- Minute 4: Nodes 9 and 2
//It takes 4 minutes for the whole tree to be infected so we return 4.
//Example 2:
//Input: root = [1], start = 1
//Output: 0
//Explanation: At minute 0, the only node in the tree is infected so we return 0.
// 
//Constraints:
//	The number of nodes in the tree is in the range [1, 105].
//	1 <= Node.val <= 105
//	Each node has a unique value.
//	A node with a value of start exists in the tree.

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


class TreeNode91 {
      int val;
      TreeNode91 left;
      TreeNode91 right;
      TreeNode91() {}
      TreeNode91(int val) { this.val = val; }
      TreeNode91(int val, TreeNode91 left, TreeNode91 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution340 {
    public int amountOfTime(TreeNode91 root, int start) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode91, TreeNode91> parent = new HashMap<>();
        dfs(root, parent, null);
        Queue<TreeNode91> q = new LinkedList<>();
        q.offer(root);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean found = false;
            for (int i = 0; i < size; i++) {
                TreeNode91 cur = q.poll();
                if (cur.val == start) {
                    found = true;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                } 
                if (parent.get(cur) != null) {
                    q.offer(parent.get(cur));
                }
            }
            if (found) {
                res++;
            }
        }
        return res;
    }
    private void dfs(TreeNode91 root, Map<TreeNode91, TreeNode91> parent, TreeNode91 pre) {
        if (root == null) {
            return;
        }
        parent.put(root, pre);
        dfs(root.left, parent, root);
        dfs(root.right, parent, root);

    }
}