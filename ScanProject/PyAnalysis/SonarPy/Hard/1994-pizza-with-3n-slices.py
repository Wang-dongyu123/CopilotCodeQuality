#https://leetcode.com/problems/pizza-with-3n-slices/
#There is a pizza with 3n slices of varying size, you and your friends will take slices of pizza as follows:
#You will pick any pizza slice.
#Your friend Alice will pick the next slice in the anti-clockwise direction of your pick.
#Your friend Bob will pick the next slice in the clockwise direction of your pick.
#Repeat until there are no more slices of pizzas.
#Given an integer array slices that represent the sizes of the pizza slices in a clockwise direction, return the maximum possible sum of slice sizes that you can pick.


class Solution(object):
    def maxSizeSlices(self, slices):
        """
        :type slices: List[int]
        :rtype: int
        """ 
        #Approach: Dynamic Programming
        #Time Complexity: O(n^2)
        #Space Complexity: O(n^2)
        #where, n is the length of slices array
        
        n = len(slices)
        m = n // 3
        
        @lru_cache(maxsize = None)
        def dp(i, j, k):
            if i > j or k == 0:
                return 0
            
            return max(dp(i + 2, j, k - 1) + slices[i], dp(i + 1, j, k))
        
        return dp(0, n - 2, m - 1)
        
        
        
    