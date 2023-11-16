package main.java.Medium; /**https://leetcode.com/problems/linked-list-in-binary-tree/ */
//Given a binary tree root and a linked list with head as the first node. 
//Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
//In this context downward path means a path that starts at some node and goes downwards.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */




class TreeNode6 {
      int val;
      TreeNode6 left;
      TreeNode6 right;
      TreeNode6() {}
      TreeNode6(int val) { this.val = val; }
      TreeNode6(int val, TreeNode6 left, TreeNode6 right) {
          this.val = val;
          this.left = left;
          this.right = right;    }
  }

class LinkedListInBinaryTree {
    public boolean isSubPath(ListNode head, TreeNode6 root) {
        if(root == null){
            return false;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
        
        
    }
    public boolean dfs(ListNode head, TreeNode6 root){
        if(head == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if(head.val != root.val){
            return false;
        }
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    
    }
}

    