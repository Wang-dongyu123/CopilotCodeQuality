#https://leetcode.com/problems/minimize-deviation-in-array/
#You are given an array nums of n positive integers.
#You can perform two types of operations on any element of the array any number of times:
#If the element is even, divide it by 2.
#For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
#If the element is odd, multiply it by 2.
#For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
#The deviation of the array is the maximum difference between any two elements in the array.
#Return the minimum deviation the array can have after performing some number of operations.


class Solution(object):
    def minimumDeviation(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        heap = []
        for num in nums:
            heapq.heappush(heap, (num / (num & -num), num))
        res = float('inf')
        while True:
            num, limit = heapq.heappop(heap)
            res = min(res, num - heap[0][0])
            if num % 2 == 1 or num < limit:
                heapq.heappush(heap, (num * 2, limit))
            else:
                break
        return res
        
    