package main.java.Medium;

import java.util.LinkedList;
import java.util.Queue;

/**https://leetcode.com/problems/populating-next-right-pointers-in-each-node/ */
//You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//Initially, all next pointers are set to NULL.



class Node6 {
    public int val;
    public Node6 left;
    public Node6 right;
    public Node6 next;

    public Node6() {}
    
    public Node6(int _val) {
        val = _val;
    }

    public Node6(int _val, Node6 _left, Node6 _right, Node6 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}


class PopulatingNextRightPointersInEachNode {
    public Node6 connect(Node6 root) {
        if(root == null){
            return null;
        }
        Queue<Node6> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node6 prev = null;
            for(int i = 0; i < size; i++){
                Node6 curr = q.poll();
                if(prev != null){
                    prev.next = curr;
                }
                prev = curr;
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return root;
        
    }
}

    