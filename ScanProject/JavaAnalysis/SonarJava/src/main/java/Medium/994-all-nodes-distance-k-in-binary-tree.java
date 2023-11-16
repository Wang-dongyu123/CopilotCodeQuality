package main.java.Medium; /**https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/ */
//Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
//You can return the answer in any order.

import javax.swing.tree.TreeNode;
import java.util.*;


class TreeNode116 {
      int val;
      TreeNode116 left;
      TreeNode116 right;
      TreeNode116(int x) { val = x; }
  }

class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode116 root, TreeNode116 target, int k) {
        Map<TreeNode116, TreeNode116> parent = new HashMap<>();
        dfs(root, null, parent);
        Queue<TreeNode116> queue = new LinkedList<>();
        queue.offer(null);
        queue.offer(target);
        Set<TreeNode116> seen = new HashSet<>();
        seen.add(target);
        seen.add(null);
        int dist = 0;
        while(!queue.isEmpty()){
            TreeNode116 node = queue.poll();
            if(node == null){
                if(dist == k){
                    List<Integer> res = new ArrayList<>();
                    for(TreeNode116 n : queue){
                        res.add(n.val);
                    }
                    return res;
                }
                queue.offer(null);
                dist++;
            }else{
                if(!seen.contains(node.left)){
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if(!seen.contains(node.right)){
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode116 par = parent.get(node);
                if(!seen.contains(par)){
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }
        return new ArrayList<>();
        
        
    }
    public void dfs(TreeNode116 node, TreeNode116 par, Map<TreeNode116, TreeNode116> parent) {
        if(node != null){
            parent.put(node, par);
            dfs(node.left, node, parent);
            dfs(node.right, node, parent);
        }
    }
}

    