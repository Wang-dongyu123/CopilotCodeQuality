#https://leetcode.com/problems/subsets-ii/
#Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
#The solution set must not contain duplicate subsets. Return the solution in any order.


class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def check(res, item):
            for i in res:
                if len(i) != len(item):
                    continue
                for j in range(len(i)):
                    if i[j] != item[j]:
                        break
                else:
                    return False
            return True
        def dfs(nums, start, item, res):
            if check(res, item):
                res.append(item[:])
            for i in range(start, len(nums)):
                item.append(nums[i])
                dfs(nums, i + 1, item, res)
                item.pop()
        nums.sort()
        res = []
        dfs(nums, 0, [], res)
        return res
        

    