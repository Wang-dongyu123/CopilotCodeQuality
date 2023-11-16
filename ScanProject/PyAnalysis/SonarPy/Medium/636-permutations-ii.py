#https://leetcode.com/problems/permutations-ii/
#Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.


class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """ 
        def dfs(nums, path, res):
            if not nums:
                res.append(path)
                return
            for i in range(len(nums)):
                if i > 0 and nums[i] == nums[i-1]:
                    continue
                dfs(nums[:i] + nums[i+1:], path + [nums[i]], res)

        res = []
        nums.sort()
        self.dfs(nums, [], res)
        return res
        

    