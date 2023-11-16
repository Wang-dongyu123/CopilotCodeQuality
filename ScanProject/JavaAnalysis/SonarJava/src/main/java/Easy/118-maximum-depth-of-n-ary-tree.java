package main.java.Easy;

import org.w3c.dom.Node;

import java.util.List;

/**https://leetcode.com/problems/maximum-depth-of-n-ary-tree/ */
//Given a n-ary tree, find its maximum depth.
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).




class Node1 {
    public int val;
    public List<Node1> children;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, List<Node1> _children) {
        val = _val;
        children = _children;
    }
};


class MaximumDepthOfNAryTree {
    public int maxDepth(Node1 root) {
        if(root == null){
            return 0;
        }
        int max = 0;
        for(Node1 child : root.children){
            max = Math.max(max, maxDepth(child));
        }
        return max + 1;
        
    }
}

    