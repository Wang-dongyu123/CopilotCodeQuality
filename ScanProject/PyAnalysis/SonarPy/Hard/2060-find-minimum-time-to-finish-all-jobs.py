#https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/
#You are given an integer array jobs, where jobs[i] is the amount of time it takes to complete the ith job.
#There are k workers that you can assign jobs to. Each job should be assigned to exactly one worker. The working time of a worker is the sum of the time it takes to complete all jobs assigned to them. Your goal is to devise an optimal assignment such that the maximum working time of any worker is minimized.
#Return the minimum possible maximum working time of any assignment.


class Solution(object):
    def minimumTimeRequired(self, jobs, k):
        """
        :type jobs: List[int]
        :type k: int
        :rtype: int
        """
        
        n = len(jobs)
        jobs.sort(reverse=True)
        workers = [0] * k
        res = [float('inf')]
        
        def dfs(i):
            if i == n:
                res[0] = min(res[0], max(workers))
                return
            seen = set()
            for j in range(k):
                if workers[j] in seen:
                    continue
                seen.add(workers[j])
                if workers[j] + jobs[i] >= res[0]:
                    continue
                workers[j] += jobs[i]
                dfs(i+1)
                workers[j] -= jobs[i]
        
        dfs(0)
        return res[0]
        
    