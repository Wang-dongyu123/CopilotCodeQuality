#https://leetcode.com/problems/cycle-length-queries-in-a-tree/
#You are given an integer n. There is a complete binary tree with 2^(n - 1) nodes. The root of that tree is the node with the value 1, and every node with a value val in the range [1, 2n - 1 - 1] has two children where:
#The left node has the value 2 * val, and
#The right node has the value 2 * val + 1.
#You are also given a 2D integer array queries of length m, where queries[i] = [ai, bi]. For each query, solve the following problem:
#Add an edge between the nodes with values ai and bi.
#Find the length of the cycle in the graph.
#Remove the added edge between nodes with values ai and bi.
#Note that:
#A cycle is a path that starts and ends at the same node, and each edge in the path is visited only once.
#The length of a cycle is the number of edges visited in the cycle.
#There could be multiple edges between two nodes in the tree after adding the edge of the query.
#Return an array answer of length m where answer[i] is the answer to the ith query.


class Solution(object):
    def cycleLengthQueries(self, n, queries):
        """
        :type n: int
        :type queries: List[List[int]]
        :rtype: List[int]
        """
        def find(x):
            if x != parent[x]:
                parent[x] = find(parent[x])
            return parent[x]
        
        def union(x, y):
            px, py = find(x), find(y)
            if px == py:
                return False
            parent[px] = py
            return True
        
        def dfs(u, fa):
            for v in graph[u]:
                if v == fa:
                    continue
                depth[v] = depth[u] + 1
                dfs(v, u)
        
        def lca(x, y):
            while depth[x] > depth[y]:
                x = parent[x]
            while depth[y] > depth[x]:
                y = parent[y]
            while x != y:
                x = parent[x]
                y = parent[y]
            return x
        
        def getLength(x, y):
            return depth[x] + depth[y] - 2 * depth[lca(x, y)]
        
        graph = collections.defaultdict(list)
        for i in range(1, 2 ** n):
            graph[i].append(i * 2)
            graph[i].append(i * 2 + 1)
        parent = range(2 ** n + 1)
        depth = [0] * (2 ** n + 1)
        res = []
        for u, v in queries:
            if union(u, v):
                dfs(u, -1)
                res.append(getLength(u, v))
            else:
                res.append(-1)
        return res
        
        
        
    