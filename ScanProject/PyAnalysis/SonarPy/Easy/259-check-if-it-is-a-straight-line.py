#https://leetcode.com/problems/check-if-it-is-a-straight-line/
#You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
# 
# 
#Example 1:
#Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
#Output: true
#Example 2:
#Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
#Output: false
# 
#Constraints:
#	2 <= coordinates.length <= 1000
#	coordinates[i].length == 2
#	-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
#	coordinates contains no duplicate point.
class Solution(object):
    def checkStraightLine(self, coordinates):
        """
        :type coordinates: List[List[int]]
        :rtype: bool
        """
        x1,y1 = coordinates[0]
        x2,y2 = coordinates[1]
        for i in range(2,len(coordinates)):
            x,y = coordinates[i]
            if (y2-y1)*(x-x1) != (y-y1)*(x2-x1):
                return False
        return True