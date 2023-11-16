package main.java.Hard; /**https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/ */
//You are given the root of a binary tree with n nodes. Each node is assigned a unique value from 1 to n. You are also given an array queries of size m.
//You have to perform m independent queries on the tree where in the ith query you do the following:
//Remove the subtree rooted at the node with the value queries[i] from the tree. It is guaranteed that queries[i] will not be equal to the value of the root.
//Return an array answer of size m where answer[i] is the height of the tree after performing the ith query.
//Note:
//The queries are independent, so the tree returns to its initial state after each query.
//The height of a tree is the number of edges in the longest simple path from the root to some node in the tree.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class HeightOfBinaryTreeAfterSubtreeRemovalQueries {
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int[] depth = new int[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(depth, -1);
        Arrays.fill(parent, -1);
        dfs(root, depth, parent, 0);
        for(int i = n-1;i>=0;i--){
            int node = queries[i];
            ans[i] = depth[node];
            depth[parent[node]] = Math.max(depth[parent[node]], depth[node] + 1);
        }
        return ans;
    }
    private void dfs(TreeNode root, int[] depth, int[] parent, int d){
        if(root == null){
            return;
        }
        depth[root.val] = d;
        if(root.left != null){
            parent[root.left.val] = root.val;
            dfs(root.left, depth, parent, d+1);
        }
        if(root.right != null){
            parent[root.right.val] = root.val;
            dfs(root.right, depth, parent, d+1);
        }
    }
}
     
    