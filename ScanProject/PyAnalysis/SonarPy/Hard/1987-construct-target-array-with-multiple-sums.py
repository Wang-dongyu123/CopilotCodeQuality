#https://leetcode.com/problems/construct-target-array-with-multiple-sums/
#You are given an array target of n integers. From a starting array arr consisting of n 1's, you may perform the following procedure :
#let x be the sum of all elements currently in your array.
#choose index i, such that 0 <= i < n and set the value of arr at index i to x.
#You may repeat this procedure as many times as needed.
#Return true if it is possible to construct the target array from arr, otherwise, return false.


class Solution(object):
    def isPossible(self, target):
        """
        :type target: List[int]
        :rtype: bool
        """ 
        #Approach: Greedy
        #Intuition: We will keep adding the maximum element in the array until all elements are 1.
        #           If the maximum element is 1, then we have reached the target.
        #           If the maximum element is > 1, then we will have to subtract the sum of all other elements from it.
        #           If the sum of all other elements is 0, then we have reached the target.
        #           If the sum of all other elements is > 0, then we will have to subtract the sum of all other elements from it.
        #           If the sum of all other elements is < 0, then we can never reach the target.
        #Time Complexity: O(n log n)
        #Space Complexity: O(n)
        #where, n is the length of target array
        
        heap = []
        sum = 0
        for num in target:
            sum += num
            heapq.heappush(heap, -num)
            
        while heap[0] != -1:
            maxElement = -heapq.heappop(heap)
            sum -= maxElement
            
            if maxElement <= sum or sum < 1:
                return False
            
            maxElement %= sum
            sum += maxElement
            heapq.heappush(heap, -maxElement or -sum)
            
        return True
        
        
        
    