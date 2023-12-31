/**https://leetcode.com/problems/most-profitable-path-in-a-tree/ */
//There is an undirected tree with n nodes labeled from 0 to n - 1, rooted at node 0. You are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
//At every node i, there is a gate. You are also given an array of even integers amount, where amount[i] represents:
//the price needed to open the gate at node i, if amount[i] is negative, or,
//the cash reward obtained on opening the gate at node i, otherwise.
//The game goes on as follows:
//Initially, Alice is at node 0 and Bob is at node bob.
//At every second, Alice and Bob each move to an adjacent node. Alice moves towards some leaf node, while Bob moves towards node 0.
//For every node along their path, Alice and Bob either spend money to open the gate at that node, or accept the reward. Note that:
//If the gate is already open, no price will be required, nor will there be any cash reward.
//If Alice and Bob reach the node simultaneously, they share the price/reward for opening the gate there. In other words, if the price to open the gate is c, then both Alice and Bob pay c / 2 each. Similarly, if the reward at the gate is c, both of them receive c / 2 each.
//If Alice reaches a leaf node, she stops moving. Similarly, if Bob reaches node 0, he stops moving. Note that these events are independent of each other.
//Return the maximum net income Alice can have if she travels towards the optimal leaf node.


/**
 * @param {number[][]} edges
 * @param {number} bob
 * @param {number[]} amount
 * @return {number}
 */
var mostProfitablePath = function(edges, bob, amount) {
    let n = amount.length;
    let adj = new Array(n);
    for (let i = 0; i < n; i++) {
        adj[i] = [];
    }
    for (let i = 0; i < edges.length; i++) {
        adj[edges[i][0]].push(edges[i][1]);
        adj[edges[i][1]].push(edges[i][0]);
    }
    let dp = new Array(n);
    for (let i = 0; i < n; i++) {
        dp[i] = new Array(n).fill(-Infinity);
    }
    let res = -Infinity;
    dfs(0, bob, 0, adj, amount, dp);
    for (let i = 0; i < n; i++) {
        res = Math.max(res, dp[i][bob]);
    }
    return res;
    
};
function dfs(i, bob, profit, adj, amount, dp) {
    if (i === bob) {
        dp[i][bob] = 0;
        return;
    }
    dp[i][bob] = profit + amount[i];
    for (let next of adj[i]) {
        if (dp[next][bob] !== -Infinity) {
            dp[i][bob] = Math.max(dp[i][bob], profit + amount[i] + dp[next][bob] / 2);
        } else {
            dfs(next, bob, profit + amount[i], adj, amount, dp);
            dp[i][bob] = Math.max(dp[i][bob], profit + amount[i] + dp[next][bob] / 2);
        }
    }
}
    