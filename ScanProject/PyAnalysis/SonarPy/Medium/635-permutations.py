#https://leetcode.com/problems/permutations/
#Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.


class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """ 
        def dfs(nums, path, res):
            if not nums:
                res.append(path)
                return
            for i in range(len(nums)):
                dfs(nums[:i] + nums[i+1:], path + [nums[i]], res)
        res = []
        dfs(nums, [], res)
        return res
         
            
           

        

    