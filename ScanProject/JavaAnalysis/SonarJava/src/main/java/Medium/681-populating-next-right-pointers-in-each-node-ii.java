package main.java.Medium;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

/**https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/ */
//Given a binary tree
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//Initially, all next pointers are set to NULL.



class Node7 {
    public int val;
    public Node7 left;
    public Node7 right;
    public Node7 next;

    public Node7() {}
    
    public Node7(int _val) {
        val = _val;
    }

    public Node7(int _val, Node7 _left, Node7 _right, Node7 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}


class PopulatingNextRightPointersInEachNodeIi {
    public Node7 connect(Node7 root) {
        if(root == null){
            return null;
        }
        Queue<Node7> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node7 prev = null;
            for(int i = 0; i < size; i++){
                Node7 curr = q.poll();
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

    