#https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
#You are given an m x n matrix mat that has its rows sorted in non-decreasing order and an integer k.
#You are allowed to choose exactly one element from each row to form an array.
#Return the kth smallest array sum among all possible arrays.


class Solution(object):
    def kthSmallest(self, mat, k):
        """
        :type mat: List[List[int]]
        :type k: int
        :rtype: int
        """ 
        #Approach: Heap
        #Time Complexity: O(m * k * log k)
        #Space Complexity: O(k)
        #where, m is the number of rows and k is the number of columns in the matrix
        
        m = len(mat)
        n = len(mat[0])
        
        res = sum(mat[i][0] for i in range(m))
        
        heap = [(res, [0] * m)]
        
        for _ in range(k - 1):
            sm, idx = heapq.heappop(heap)
            
            for i in range(m):
                if idx[i] < n - 1:
                    idx[i] += 1
                    heapq.heappush(heap, (sm + mat[i][idx[i]] - mat[i][idx[i] - 1], idx[:]))
                    idx[i] -= 1
                    
        return heapq.heappop(heap)[0]
        
        
        
        
    