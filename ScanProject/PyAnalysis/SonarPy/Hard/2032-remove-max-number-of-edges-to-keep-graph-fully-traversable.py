#https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
#Alice and Bob have an undirected graph of n nodes and three types of edges:
#Type 1: Can be traversed by Alice only.
#Type 2: Can be traversed by Bob only.
#Type 3: Can be traversed by both Alice and Bob.
#Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi, find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.
#Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph.


class Solution(object):
    def maxNumEdgesToRemove(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: int
        """       
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        
        def union(x, y):
            parent[find(x)] = find(y)
            
        parent = range(n+1)
        ans = 0
        for t, u, v in edges:
            if t == 3:
                if find(u) == find(v):
                    ans += 1
                else:
                    union(u, v)
        parent1 = copy.deepcopy(parent)
        for t, u, v in edges:
            if t == 1:
                if find(u) == find(v):
                    ans += 1
                else:
                    union(u, v)
        parent2 = copy.deepcopy(parent)
        for t, u, v in edges:
            if t == 2:
                if find(u) == find(v):
                    ans += 1
                else:
                    union(u, v)
        if len(set([find(i) for i in range(1, n+1)])) != 1:
            return -1
        return ans
        
        
        
    