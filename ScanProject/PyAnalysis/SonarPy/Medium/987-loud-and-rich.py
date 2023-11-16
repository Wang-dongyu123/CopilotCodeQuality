#https://leetcode.com/problems/loud-and-rich/
#There is a group of n people labeled from 0 to n - 1 where each person has a different amount of money and a different level of quietness.
#You are given an array richer where richer[i] = [ai, bi] indicates that ai has more money than bi and an integer array quiet where quiet[i] is the quietness of the ith person. All the given data in richer are logically correct (i.e., the data will not lead you to a situation where x is richer than y and y is richer than x at the same time).
#Return an integer array answer where answer[x] = y if y is the least quiet person (that is, the person y with the smallest value of quiet[y]) among all people who definitely have equal to or more money than the person x.


class Solution(object):
    def loudAndRich(self, richer, quiet):
        """
        :type richer: List[List[int]]
        :type quiet: List[int]
        :rtype: List[int]
        """                                                                                         
        def findQuietest(richer, quiet, x):
            if res[x] != -1:
                return res[x]
            res[x] = x
            for y in graph[x]:
                if quiet[res[x]] > quiet[findQuietest(richer, quiet, y)]:
                    res[x] = res[y]
            return res[x]
        graph = collections.defaultdict(list)
        for x, y in richer:
            graph[y].append(x)            




        

    