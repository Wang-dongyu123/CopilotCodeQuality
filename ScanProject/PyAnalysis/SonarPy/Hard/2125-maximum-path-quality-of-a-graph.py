#https://leetcode.com/problems/maximum-path-quality-of-a-graph/
#There is an undirected graph with n nodes numbered from 0 to n - 1 (inclusive). You are given a 0-indexed integer array values where values[i] is the value of the ith node. You are also given a 0-indexed 2D integer array edges, where each edges[j] = [uj, vj, timej] indicates that there is an undirected edge between the nodes uj and vj, and it takes timej seconds to travel between the two nodes. Finally, you are given an integer maxTime.
#A valid path in the graph is any path that starts at node 0, ends at node 0, and takes at most maxTime seconds to complete. You may visit the same node multiple times. The quality of a valid path is the sum of the values of the unique nodes visited in the path (each node's value is added at most once to the sum).
#Return the maximum quality of a valid path.
#Note: There are at most four edges connected to each node.


class Solution(object):
    def maximalPathQuality(self, values, edges, maxTime):
        """
        :type values: List[int]
        :type edges: List[List[int]]
        :type maxTime: int
        :rtype: int
        """
        g = collections.defaultdict(list)
        for u, v, t in edges:
            g[u].append((v, t))
            g[v].append((u, t))
        n = len(values)
        @lru_cache(None)
        def dfs(u, t):
            if u == 0 and t == 0:
                return values[u]
            if t < 0:
                return float('-inf')
            res = float('-inf')
            for v, cost in g[u]:
                res = max(res, values[u] + dfs(v, t - cost))
            return res
        return max(dfs(0, t) for t in range(maxTime+1))
        
        
    