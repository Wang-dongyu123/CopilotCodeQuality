package main.java.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**https://leetcode.com/problems/n-ary-tree-level-order-traversal/ */
//Given an n-ary tree, return the level order traversal of its nodes' values.
//Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
// 
//Example 1:
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [[1],[3,2,4],[5,6]]
//Example 2:
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
//Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//Constraints:
//	The height of the n-ary tree is less than or equal to 1000
//	The total number of nodes is between [0, 104]

class Node5 {
    public int val;
    public List<Node5> children;

    public Node5() {}

    public Node5(int _val) {
        val = _val;
    }

    public Node5(int _val, List<Node5> _children) {
        val = _val;
        children = _children;
    }
};


class Solution491 {
    public List<List<Integer>> levelOrder(Node5 root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node5> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            while (size > 0) {
                Node5 node = q.poll();
                tmp.add(node.val);
                for (Node5 child : node.children) {
                    q.offer(child);
                }
                size--;
            }
            result.add(tmp);
        }
        return result;
    }
}