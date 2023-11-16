#https://leetcode.com/problems/maximum-score-of-a-node-sequence/
#There is an undirected graph with n nodes, numbered from 0 to n - 1.
#You are given a 0-indexed integer array scores of length n where scores[i] denotes the score of node i. You are also given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.
#A node sequence is valid if it meets the following conditions:
#There is an edge connecting every pair of adjacent nodes in the sequence.
#No node appears more than once in the sequence.
#The score of a node sequence is defined as the sum of the scores of the nodes in the sequence.
#Return the maximum score of a valid node sequence with a length of 4. If no such sequence exists, return -1.


class Solution(object):
    def maximumScore(self, scores, edges):
        """
        :type scores: List[int]
        :type edges: List[List[int]]
        :rtype: int
        """
        n = len(scores)
        graph = collections.defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        visited = [False] * n
        res = 0
        for i in range(n):
            visited[i] = True
            for j in graph[i]:
                if not visited[j]:
                    visited[j] = True
                    for k in graph[j]:
                        if not visited[k]:
                            res = max(res, scores[i] + scores[j] + scores[k])
                    visited[j] = False
            visited[i] = False
        return res
        
        
    