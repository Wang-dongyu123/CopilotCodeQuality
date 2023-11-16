package main.java.Easy; /**https://leetcode.com/problems/subtree-of-another-tree/ */
//Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
//A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
class TreeNode11 {
      int val;
      TreeNode11 left;
      TreeNode11 right;
      TreeNode11() {}
      TreeNode11(int val) { this.val = val; }
      TreeNode11(int val, TreeNode11 left, TreeNode11 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode11 root, TreeNode11 subRoot) {
        if(root == null) return false;
        if(isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
        
    }
    private boolean isSameTree(TreeNode11 root1, TreeNode11 root2){
        if(root1 == null && root2 == null) return true;
        if(root1 != null && root2 != null && root1.val == root2.val){
            return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        }
        return false;
    }
}

    