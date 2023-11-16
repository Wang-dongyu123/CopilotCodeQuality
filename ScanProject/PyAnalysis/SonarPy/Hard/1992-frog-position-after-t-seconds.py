#https://leetcode.com/problems/frog-position-after-t-seconds/
#Given an undirected tree consisting of n vertices numbered from 1 to n. A frog starts jumping from vertex 1. In one second, the frog jumps from its current vertex to another unvisited vertex if they are directly connected. The frog can not jump back to a visited vertex. In case the frog can jump to several vertices, it jumps randomly to one of them with the same probability. Otherwise, when the frog can not jump to any unvisited vertex, it jumps forever on the same vertex.
#The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi.
#Return the probability that after t seconds the frog is on the vertex target. Answers within 10-5 of the actual answer will be accepted.


class Solution(object):
    def frogPosition(self, n, edges, t, target):
        """
        :type n: int
        :type edges: List[List[int]]
        :type t: int
        :type target: int
        :rtype: float
        """                      
        #Approach: DFS
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the number of vertices in the tree
        
        graph = [[] for _ in range(n + 1)]
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
            
        visited = [False for _ in range(n + 1)]
        visited[1] = True
        
        def dfs(node, time):
            if node == target:
                return 1 if time == t or (time < t and not graph[node]) else 0
            
            ans = 0
            for child in graph[node]:
                if not visited[child]:
                    visited[child] = True
                    ans += dfs(child, time + 1)
                    
            return ans * 1.0 / len(graph[node])
        
        return dfs(1, 0)
        
        
        
    