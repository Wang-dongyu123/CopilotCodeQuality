#https://leetcode.com/problems/constrained-subsequence-sum/
#Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence of that array such that for every two consecutive integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.
#A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array, leaving the remaining elements in their original order.


class Solution(object):
    def constrainedSubsetSum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """ 
        #Approach: Deque
        #Time Complexity: O(n)
        #Space Complexity: O(k)
        #where, n is the length of nums array
        
        dq = deque()
        res = -float('inf')
        
        for i in range(len(nums)):
            while dq and dq[0][1] < i - k:
                dq.popleft()
                
            curr = max(nums[i], nums[i] + (dq[0][0] if dq else 0))
            res = max(res, curr)
            
            while dq and dq[-1][0] <= curr:
                dq.pop()
                
            dq.append((curr, i))
            
        return res
    
        #Approach: Dynamic Programming
        #Time Complexity: O(n^2)
        #Space Complexity: O(n)
        #where, n is the length of nums array
        
        
        
    