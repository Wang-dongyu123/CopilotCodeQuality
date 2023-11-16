package main.java.Hard; /**https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/ */
//We run a preorder depth-first search (DFS) on the root of a binary tree.
//At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  If the depth of a node is D, the depth of its immediate child is D + 1.  The depth of the root node is 0.
//If a node has only one child, that child is guaranteed to be the left child.
//Given the output traversal of this traversal, recover the tree and return its root.


import javax.swing.tree.TreeNode;
import java.util.Stack;


class TreeNode47 {
      int val;
      TreeNode47 left;
      TreeNode47 right;
      TreeNode47() {}
      TreeNode47(int val) { this.val = val; }
      TreeNode47(int val, TreeNode47 left, TreeNode47 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class RecoverATreeFromPreorderTraversal {
    public TreeNode47 recoverFromPreorder(String traversal) {
        Stack<TreeNode47> stack = new Stack<>();
        int i = 0;
        while (i < traversal.length()) {
            int level = 0;
            while (traversal.charAt(i) == '-') {
                level++;
                i++;
            }
            int val = 0;
            while (i < traversal.length() && traversal.charAt(i) != '-') {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }
            TreeNode47 node = new TreeNode47(val);
            if (level == stack.size()) {
                if (!stack.isEmpty()) {
                    stack.peek().left = node;
                }
            } else {
                while (level != stack.size()) {
                    stack.pop();
                }
                stack.peek().right = node;
            }
            stack.push(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
        
    }
}
     
    