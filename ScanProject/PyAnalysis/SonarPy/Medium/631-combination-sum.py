#https://leetcode.com/problems/combination-sum/
#Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
#The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
#The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
# 


class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        def dfs(nums, target, pos, path, res):
            if target == 0:
                res.append(path[:])
                return
            for i in range(pos, len(nums)):
                if nums[i] > target:
                    break
                path.append(nums[i])
                dfs(nums, target - nums[i], i, path, res)
                path.pop()
        res = []
        dfs(candidates, target, 0, [], res)
        return res
        

    