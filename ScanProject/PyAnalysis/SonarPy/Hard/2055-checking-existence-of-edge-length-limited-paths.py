#https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/
#An undirected graph of n nodes is defined by edgeList, where edgeList[i] = [ui, vi, disi] denotes an edge between nodes ui and vi with distance disi. Note that there may be multiple edges between two nodes.
#Given an array queries, where queries[j] = [pj, qj, limitj], your task is to determine for each queries[j] whether there is a path between pj and qj such that each edge on the path has a distance strictly less than limitj .
#Return a boolean array answer, where answer.length == queries.length and the jth value of answer is true if there is a path for queries[j] is true, and false otherwise.


class Solution(object):
    def distanceLimitedPathsExist(self, n, edgeList, queries):
        """
        :type n: int
        :type edgeList: List[List[int]]
        :type queries: List[List[int]]
        :rtype: List[bool]
        """
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        
        def union(x, y):
            parent[find(x)] = find(y)
            
        parent = range(n)
        edgeList.sort(key = lambda x: x[2])
        queries = sorted([(p, q, limit, i) for i, (p, q, limit) in enumerate(queries)], key = lambda x: x[2])
        ans = [False] * len(queries)
        i = 0
        for p, q, limit, idx in queries:
            while i < len(edgeList) and edgeList[i][2] < limit:
                union(edgeList[i][0], edgeList[i][1])
                i += 1
            ans[idx] = find(p) == find(q)
        return ans
        
        
    