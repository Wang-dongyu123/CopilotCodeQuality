#https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/
#You have n tasks and m workers. Each task has a strength requirement stored in a 0-indexed integer array tasks, with the ith task requiring tasks[i] strength to complete. The strength of each worker is stored in a 0-indexed integer array workers, with the jth worker having workers[j] strength. Each worker can only be assigned to a single task and must have a strength greater than or equal to the task's strength requirement (i.e., workers[j] >= tasks[i]).
#Additionally, you have pills magical pills that will increase a worker's strength by strength. You can decide which workers receive the magical pills, however, you may only give each worker at most one magical pill.
#Given the 0-indexed integer arrays tasks and workers and the integers pills and strength, return the maximum number of tasks that can be completed.


class Solution(object):
    def maxTaskAssign(self, tasks, workers, pills, strength):
        """
        :type tasks: List[int]
        :type workers: List[int]
        :type pills: int
        :type strength: int
        :rtype: int
        """
        n = len(tasks)
        m = len(workers)
        tasks.sort()
        workers.sort()
        i = 0
        j = 0
        while i < n and j < m:
            if workers[j] < tasks[i]:
                j += 1
            else:
                i += 1
                j += 1
        return i + min(pills, m - j)
        
        
    