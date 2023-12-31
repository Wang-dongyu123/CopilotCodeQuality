#https://leetcode.com/problems/second-minimum-time-to-reach-destination/
#A city is represented as a bi-directional connected graph with n vertices where each vertex is labeled from 1 to n (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself. The time taken to traverse any edge is time minutes.
#Each vertex has a traffic signal which changes its color from green to red and vice versa every change minutes. All signals change at the same time. You can enter a vertex at any time, but can leave a vertex only when the signal is green. You cannot wait at a vertex if the signal is green.
#The second minimum value is defined as the smallest value strictly larger than the minimum value.
#For example the second minimum value of [2, 3, 4] is 3, and the second minimum value of [2, 2, 4] is 4.
#Given n, edges, time, and change, return the second minimum time it will take to go from vertex 1 to vertex n.


class Solution(object):
    def secondMinimum(self, n, edges, time, change):
        """
        :type n: int
        :type edges: List[List[int]]
        :type time: int
        :type change: int
        :rtype: int
        """        
        graph = collections.defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        dist = [float('inf')] * (n+1)
        dist[1] = 0
        q = [(0, 1)]
        while q:
            d, u = heapq.heappop(q)
            if dist[u] < d:
                continue
            for v in graph[u]:
                if (d // change) % 2 == 0:
                    if dist[v] > d + time:
                        dist[v] = d + time
                        heapq.heappush(q, (dist[v], v))
                else:
                    if dist[v] > d + change - d % change + time:
                        dist[v] = d + change - d % change + time
                        heapq.heappush(q, (dist[v], v))
        return dist[-1]
        
        
    