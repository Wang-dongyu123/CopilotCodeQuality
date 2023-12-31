#https://leetcode.com/problems/combination-sum-iii/
#Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
#Only numbers 1 through 9 are used.
#Each number is used at most once.
#Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.


class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        def dfs(nums, k, n, start, item, res):
            if len(item) == k and sum(item) == n:
                res.append(item[:])
            for i in range(start, len(nums)):
                item.append(nums[i])
                dfs(nums, k, n, i + 1, item, res)
                item.pop()
        res = []
        self.dfs(range(1, 10), k, n, 0, [], res)
        return res
        

    