#https://leetcode.com/problems/find-all-people-with-secret/
#You are given an integer n indicating there are n people numbered from 0 to n - 1. You are also given a 0-indexed 2D integer array meetings where meetings[i] = [xi, yi, timei] indicates that person xi and person yi have a meeting at timei. A person may attend multiple meetings at the same time. Finally, you are given an integer firstPerson.
#Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. This secret is then shared every time a meeting takes place with a person that has the secret. More formally, for every meeting, if a person xi has the secret at timei, then they will share the secret with person yi, and vice versa.
#The secrets are shared instantaneously. That is, a person may receive the secret and share it with people in other meetings within the same time frame.
#Return a list of all the people that have the secret after all the meetings have taken place. You may return the answer in any order.


class Solution(object):
    def findAllPeople(self, n, meetings, firstPerson):
        """
        :type n: int
        :type meetings: List[List[int]]
        :type firstPerson: int
        :rtype: List[int]
        """
        g = collections.defaultdict(list)
        for u, v, t in meetings:
            g[u].append((t, v))
            g[v].append((t, u))
        q = collections.deque()
        q.append((0, firstPerson))
        seen = set([firstPerson])
        while q:
            t, u = q.popleft()
            for v in g[u]:
                if v[0] == t and v[1] not in seen:
                    q.append(v)
                    seen.add(v[1])
        return list(seen)

