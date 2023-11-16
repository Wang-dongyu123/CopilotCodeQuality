#https://leetcode.com/problems/summary-ranges/
#You are given a sorted unique integer array nums.
#A range [a,b] is the set of all integers from a to b (inclusive).
#Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
#Each range [a,b] in the list should be output as:
#"a->b" if a != b
#"a" if a == b


class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """ 
        if len(nums)==0:
            return []
        if len(nums)==1:
            return [str(nums[0])]
        result=[]
        start=nums[0]
        end=nums[0]
        for i in range(1,len(nums)):
            if nums[i]==end+1:
                end=nums[i]
            else:
                if start==end:
                    result.append(str(start))
                else:
                    result.append(str(start)+"->"+str(end))
                start=nums[i]
                end=nums[i]
        if start==end:
            result.append(str(start))
        else:
            result.append(str(start)+"->"+str(end))
        return result

    