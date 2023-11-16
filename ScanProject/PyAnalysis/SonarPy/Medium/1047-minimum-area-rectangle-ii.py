#https://leetcode.com/problems/minimum-area-rectangle-ii/
#You are given an array of points in the X-Y plane points where points[i] = [xi, yi].
#Return the minimum area of any rectangle formed from these points, with sides not necessarily parallel to the X and Y axes. If there is not any such rectangle, return 0.
#Answers within 10-5 of the actual answer will be accepted.


class Solution(object):
    def minAreaFreeRect(self, points):
        """
        :type points: List[List[int]]
        :rtype: float
        """
        res = float('inf')
        points = set(map(tuple, points))
        for i in range(len(points)):
            for j in range(i+1, len(points)):
                x1, y1 = points[i]
                x2, y2 = points[j]
                if x1 != x2 and y1 != y2 and (x1, y2) in points and (x2, y1) in points:
                    res = min(res, abs(x1-x2) * abs(y1-y2))
        return res if res != float('inf') else 0
        

    