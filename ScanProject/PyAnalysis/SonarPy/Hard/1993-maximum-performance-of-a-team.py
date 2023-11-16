#https://leetcode.com/problems/maximum-performance-of-a-team/
#You are given two integers n and k and two integer arrays speed and efficiency both of length n. There are n engineers numbered from 1 to n. speed[i] and efficiency[i] represent the speed and efficiency of the ith engineer respectively.
#Choose at most k different engineers out of the n engineers to form a team with the maximum performance.
#The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.
#Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 109 + 7.


class Solution(object):
    def maxPerformance(self, n, speed, efficiency, k):
        """
        :type n: int
        :type speed: List[int]
        :type efficiency: List[int]
        :type k: int
        :rtype: int
        """      
        #Approach: Greedy
        #Intuition: We will greedily choose the engineers with higher efficiency and speed.
        #           We will maintain a heap of speeds of the chosen engineers, and remove the lowest speed when the size exceeds k.
        #           We will also maintain the sum of the speeds of the chosen engineers, and update the result accordingly.
        #Time Complexity: O(n log n)
        #Space Complexity: O(n)
        #where, n is the length of efficiency/speed array
        
        engineers = sorted(zip(efficiency, speed), reverse = True)
        
        heap = []
        sum = 0
        res = 0
        for eff, spd in engineers:
            sum += spd
            heapq.heappush(heap, spd)
            
            if len(heap) > k:
                sum -= heapq.heappop(heap)
                
            res = max(res, sum * eff)
            
        return res % (10 ** 9 + 7)
        
        
        
    