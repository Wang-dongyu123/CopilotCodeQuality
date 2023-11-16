package main.java.Medium;

import org.w3c.dom.Node;

import java.util.*;

/**https://leetcode.com/problems/clone-graph/ */
//Given a reference of a node in a connected undirected graph.
//Return a deep copy (clone) of the graph.
//Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
//class Node {
//    public int val;
//    public List<Node> neighbors;
//}
// 
//Test case format:
//For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
//An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
//The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.



class Node8 {
    public int val;
    public List<Node8> neighbors;
    public Node8() {
        val = 0;
        neighbors = new ArrayList<Node8>();
    }
    public Node8(int _val) {
        val = _val;
        neighbors = new ArrayList<Node8>();
    }
    public Node8(int _val, ArrayList<Node8> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class CloneGraph {
    public Node8 cloneGraph(Node8 node) {
        if(node == null){
            return null;
        }
        Map<Node8, Node8> map = new HashMap<>();
        Queue<Node8> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node8(node.val));
        while(!queue.isEmpty()){
            Node8 curr = queue.poll();
            for(Node8 neighbor : curr.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new Node8(neighbor.val));
                    queue.add(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
        
    }
}

    