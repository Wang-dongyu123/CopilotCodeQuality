#https://leetcode.com/problems/circular-array-loop/
#You are playing a game involving a circular array of non-zero integers nums. Each nums[i] denotes the number of indices forward/backward you must move if you are located at index i:
#If nums[i] is positive, move nums[i] steps forward, and
#If nums[i] is negative, move nums[i] steps backward.
#Since the array is circular, you may assume that moving forward from the last element puts you on the first element, and moving backwards from the first element puts you on the last element.
#A cycle in the array consists of a sequence of indices seq of length k where:
#Following the movement rules above results in the repeating index sequence seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
#Every nums[seq[j]] is either all positive or all negative.
#k > 1
#Return true if there is a cycle in nums, or false otherwise.


class Solution(object):
    def circularArrayLoop(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
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
          
     
    
     
        

    