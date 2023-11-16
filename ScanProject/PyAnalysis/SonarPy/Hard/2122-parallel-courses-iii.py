#https://leetcode.com/problems/parallel-courses-iii/
#You are given an integer n, which indicates that there are n courses labeled from 1 to n. You are also given a 2D integer array relations where relations[j] = [prevCoursej, nextCoursej] denotes that course prevCoursej has to be completed before course nextCoursej (prerequisite relationship). Furthermore, you are given a 0-indexed integer array time where time[i] denotes how many months it takes to complete the (i+1)th course.
#You must find the minimum number of months needed to complete all the courses following these rules:
#You may start taking a course at any time if the prerequisites are met.
#Any number of courses can be taken at the same time.
#Return the minimum number of months needed to complete all the courses.
#Note: The test cases are generated such that it is possible to complete every course (i.e., the graph is a directed acyclic graph).


class Solution(object):
    def minimumTime(self, n, relations, time):
        """
        :type n: int
        :type relations: List[List[int]]
        :type time: List[int]
        :rtype: int
        """
        def check(mid):
            indegree = [0] * (n+1)
            for u, v in relations:
                indegree[v] += 1
            q = collections.deque()
            for i in range(1, n+1):
                if indegree[i] == 0:
                    q.append(i)
            while q:
                u = q.popleft()
                for v in g[u]:
                    indegree[v] -= 1
                    if indegree[v] == 0:
                        q.append(v)
            return all(indegree[i] == 0 for i in range(1, n+1))
        
        g = collections.defaultdict(list)
        for u, v in relations:
            g[u].append(v)
        l, r = 0, sum(time)
        while l < r:
            mid = (l + r) / 2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l
        
        
    