package main.java.Easy;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**https://leetcode.com/problems/n-ary-tree-preorder-traversal/ */
//Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
//Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)



class Node2 {
    public int val;
    public List<Node2> children;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, List<Node2> _children) {
        val = _val;
        children = _children;
    }
};


class NAryTreePreorderTraversal {
    public List<Integer> preorder(Node2 root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node2> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node2 node = stack.pop();
            res.add(node.val);
            for(int i = node.children.size() - 1; i >= 0; i--){
                stack.push(node.children.get(i));
            }
        }
        return res;
        
        
    }
}

    