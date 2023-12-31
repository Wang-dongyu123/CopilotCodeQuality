package main.java.Medium; /**https://leetcode.com/problems/maximum-binary-tree-ii/ */
//A maximum tree is a tree where every node has a value greater than any other value in its subtree.
//You are given the root of a maximum binary tree and an integer val.
//Just as in the previous problem, the given tree was constructed from a list a (root = Construct(a)) recursively with the following Construct(a) routine:
//If a is empty, return null.
//Otherwise, let a[i] be the largest element of a. Create a root node with the value a[i].
//The left child of root will be Construct([a[0], a[1], ..., a[i - 1]]).
//The right child of root will be Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]).
//Return root.
//Note that we were not given a directly, only a root node root = Construct(a).
//Suppose b is a copy of a with the value val appended to it. It is guaranteed that b has unique values.
//Return Construct(b).


import javax.swing.tree.TreeNode;


class TreeNode58 {
      int val;
      TreeNode58 left;
      TreeNode58 right;
      TreeNode58() {}
      TreeNode58(int val) { this.val = val; }
      TreeNode58(int val, TreeNode58 left, TreeNode58 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class MaximumBinaryTreeIi {
    public TreeNode58 insertIntoMaxTree(TreeNode58 root, int val) {
        if(root == null){
            return new TreeNode58(val);
        }
        if(root.val < val){
            TreeNode58 node = new TreeNode58(val);
            node.left = root;
            return node;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
        
        
    }
}

    