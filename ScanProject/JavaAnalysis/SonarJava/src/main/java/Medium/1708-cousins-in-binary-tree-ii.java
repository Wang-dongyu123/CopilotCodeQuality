package main.java.Medium; /**https://leetcode.com/problems/cousins-in-binary-tree-ii/ */
//Given the root of a binary tree, replace the value of each node in the tree with the sum of all its cousins' values.
//Two nodes of a binary tree are cousins if they have the same depth with different parents.
//Return the root of the modified tree.
//Note that the depth of a node is the number of edges in the path from the root node to it.
// 
//Example 1:
//Input: root = [5,4,9,1,10,null,7]
//Output: [0,0,0,7,7,null,11]
//Explanation: The diagram above shows the initial binary tree and the binary tree after changing the value of each node.
//- Node with value 5 does not have any cousins so its sum is 0.
//- Node with value 4 does not have any cousins so its sum is 0.
//- Node with value 9 does not have any cousins so its sum is 0.
//- Node with value 1 has a cousin with value 7 so its sum is 7.
//- Node with value 10 has a cousin with value 7 so its sum is 7.
//- Node with value 7 has cousins with values 1 and 10 so its sum is 11.
//Example 2:
//Input: root = [3,1,2]
//Output: [0,0,0]
//Explanation: The diagram above shows the initial binary tree and the binary tree after changing the value of each node.
//- Node with value 3 does not have any cousins so its sum is 0.
//- Node with value 1 does not have any cousins so its sum is 0.
//- Node with value 2 does not have any cousins so its sum is 0.
// 
//Constraints:
//	The number of nodes in the tree is in the range [1, 105].
//	1 <= Node.val <= 104

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
class TreeNode1 {
      int val;
      TreeNode1 left;
      TreeNode1 right;
      TreeNode1() {}
      TreeNode1(int val) { this.val = val; }
      TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution391 {
    public TreeNode1 replaceValueInTree(TreeNode1 root) {
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, Integer> cousins = new HashMap<>();
            for (int i = 0; i < size; i++) {
                TreeNode1 curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                    cousins.put(curr.left.val, curr.val);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    cousins.put(curr.right.val, curr.val);
                }
            }
            for (Map.Entry<Integer, Integer> entry : cousins.entrySet()) {
                int cousinVal = entry.getKey();
                int parentVal = entry.getValue();
                TreeNode1 cousinNode = findNode(root, cousinVal);
                cousinNode.val += parentVal;
            }
        }
        return root;
    }

    private TreeNode1 findNode(TreeNode1 root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode1 left = findNode(root.left, val);
        TreeNode1 right = findNode(root.right, val);
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}