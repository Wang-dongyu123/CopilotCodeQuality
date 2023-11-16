package main.java.Medium; /**https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/ */
//Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
//It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
//A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
//A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.


class TreeNode44 {
      int val;
      TreeNode44 left;
      TreeNode44 right;
      TreeNode44() {}
     TreeNode44(int val) { this.val = val; }
      TreeNode44(int val, TreeNode44 left, TreeNode44 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode44 bstFromPreorder(int[] preorder) {
        TreeNode44 root = new TreeNode44(preorder[0]);
        for(int i = 1; i < preorder.length; i++){
            insert(root, preorder[i]);
        }
        return root;
        
        
    }
    private void insert(TreeNode44 root, int val){
        if(root.val > val){
            if(root.left == null){
                root.left = new TreeNode44(val);
            }
            else{
                insert(root.left, val);
            }
        }
        else{
            if(root.right == null){
                root.right = new TreeNode44(val);
            }
            else{
                insert(root.right, val);
            }
        }
    }
}

    