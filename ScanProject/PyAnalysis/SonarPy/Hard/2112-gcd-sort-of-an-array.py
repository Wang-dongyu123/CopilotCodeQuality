#https://leetcode.com/problems/gcd-sort-of-an-array/
#You are given an integer array nums, and you can perform the following operation any number of times on nums:
#Swap the positions of two elements nums[i] and nums[j] if gcd(nums[i], nums[j]) > 1 where gcd(nums[i], nums[j]) is the greatest common divisor of nums[i] and nums[j].
#Return true if it is possible to sort nums in non-decreasing order using the above swap method, or false otherwise.


class Solution(object):
    def gcdSort(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        
        def union(x, y):
            parent[find(x)] = find(y)
            
        parent = range(max(nums) + 1)
        for x in nums:
            for i in range(2, int(x**0.5) + 1):
                if x % i == 0:
                    union(x, i)
                    union(x, x/i)
        return sorted(nums) == sorted(nums, key=find)
        
        
    