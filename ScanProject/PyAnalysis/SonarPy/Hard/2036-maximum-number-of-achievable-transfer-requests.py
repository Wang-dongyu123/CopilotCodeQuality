#https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/
#We have n buildings numbered from 0 to n - 1. Each building has a number of employees. It's transfer season, and some employees want to change the building they reside in.
#You are given an array requests where requests[i] = [fromi, toi] represents an employee's request to transfer from building fromi to building toi.
#All buildings are full, so a list of requests is achievable only if for each building, the net change in employee transfers is zero. This means the number of employees leaving is equal to the number of employees moving in. For example if n = 3 and two employees are leaving building 0, one is leaving building 1, and one is leaving building 2, there should be two employees moving to building 0, one employee moving to building 1, and one employee moving to building 2.
#Return the maximum number of achievable requests.


class Solution(object):
    def maximumRequests(self, n, requests):
        """
        :type n: int
        :type requests: List[List[int]]
        :rtype: int
        """     
        
        def dfs(i, count):
            if i == len(requests):
                if all(x == 0 for x in buildings):
                    return count
                else:
                    return 0
            f, t = requests[i]
            buildings[f] -= 1
            buildings[t] += 1
            res = dfs(i+1, count+1)
            buildings[f] += 1
            buildings[t] -= 1
            res = max(res, dfs(i+1, count))
            return res
        buildings = [0] * n
        return dfs(0, 0)
        
        
    