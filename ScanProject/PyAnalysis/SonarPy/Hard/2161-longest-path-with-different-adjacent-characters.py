#https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
#You are given a tree (i.e. a connected, undirected graph that has no cycles) rooted at node 0 consisting of n nodes numbered from 0 to n - 1. The tree is represented by a 0-indexed array parent of size n, where parent[i] is the parent of node i. Since node 0 is the root, parent[0] == -1.
#You are also given a string s of length n, where s[i] is the character assigned to node i.
#Return the length of the longest path in the tree such that no pair of adjacent nodes on the path have the same character assigned to them.


class Solution(object):
    def longestPath(self, parent, s):
        """
        :type parent: List[int]
        :type s: str
        :rtype: int
        """
        n = len(parent)
        graph = collections.defaultdict(list)
        for i in range(1, n):
            graph[parent[i]].append(i)
        ans = 0
        def dfs(node, parent, s):
            nonlocal ans
            if parent != -1 and s[node] == s[parent]:
                return 0
            res = 0
            for child in graph[node]:
                res = max(res, dfs(child, node, s))
            ans = max(ans, res + 1)
            return res + 1
        dfs(0, -1, s)
        return ans
        
        
    