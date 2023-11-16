package main.java.Medium; /**https://leetcode.com/problems/delete-node-in-a-bst/ */
//Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
//Basically, the deletion can be divided into two stages:
//Search for a node to remove.
//If the node is found, delete the node.

class TreeNode103 {
     int val;
      TreeNode103 left;
      TreeNode103 right;
      TreeNode103() {}
      TreeNode103(int val) { this.val = val; }
     TreeNode103(int val, TreeNode103 left, TreeNode103 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class DeleteNodeInABst {
    public TreeNode103 deleteNode(TreeNode103 root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                TreeNode103 min = findMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            root.right = deleteNode(root.right, key);
        }
        return root;
        
    }
    private TreeNode103 findMin(TreeNode103 root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

}

    