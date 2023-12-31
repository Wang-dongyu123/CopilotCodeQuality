/**https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/ */
//You are given an undirected graph (the "original graph") with n nodes labeled from 0 to n - 1. You decide to subdivide each edge in the graph into a chain of nodes, with the number of new nodes varying between each edge.
//The graph is given as a 2D array of edges where edges[i] = [ui, vi, cnti] indicates that there is an edge between nodes ui and vi in the original graph, and cnti is the total number of new nodes that you will subdivide the edge into. Note that cnti == 0 means you will not subdivide the edge.
//To subdivide the edge [ui, vi], replace it with (cnti + 1) new edges and cnti new nodes. The new nodes are x1, x2, ..., xcnti, and the new edges are [ui, x1], [x1, x2], [x2, x3], ..., [xcnti-1, xcnti], [xcnti, vi].
//In this new graph, you want to know how many nodes are reachable from the node 0, where a node is reachable if the distance is maxMoves or less.
//Given the original graph and maxMoves, return the number of nodes that are reachable from node 0 in the new graph.


/**
 * @param {number[][]} edges
 * @param {number} maxMoves
 * @param {number} n
 * @return {number}
 */
var reachableNodes = function(edges, maxMoves, n) {
    let dp = [];
    for(let i = 0; i <= n; i++){
        dp.push([]);
        for(let j = 0; j <= maxMoves; j++){
            dp[i].push(0);
        }
    }
    for(let i = 1; i <= n; i++){
        for(let j = 1; j <= maxMoves; j++){
            if(i - j >= 0){
                dp[i][j] = Math.max(dp[i - 1][j], nums[i - 1]);
            }
            else{
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    let ans = [];
    for(let i = maxMoves; i <= n; i++){
        ans.push(dp[i][maxMoves]);
    }
    return ans;
    
};
function getDistance(p1, p2){
    let [x1, y1] = p1;
    let [x2, y2] = p2;
    return (x1 - x2) ** 2 + (y1 - y2) ** 2;
}

    