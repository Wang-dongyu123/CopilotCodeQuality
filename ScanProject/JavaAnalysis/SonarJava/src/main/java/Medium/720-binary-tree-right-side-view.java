package main.java.Medium; /**https://leetcode.com/problems/binary-tree-right-side-view/ */
//Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.


import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class TreeNode97 {
      int val;
      TreeNode97 left;
      TreeNode97 right;
      TreeNode97() {}
      TreeNode97(int val) { this.val = val; }
      TreeNode97(int val, TreeNode97 left, TreeNode97 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode97 root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode97> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode97 node = queue.poll();
                if(i == size - 1){
                    result.add(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return result;
        
        
        
    }
}

    