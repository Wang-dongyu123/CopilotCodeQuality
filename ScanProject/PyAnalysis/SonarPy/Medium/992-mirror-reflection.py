#https://leetcode.com/problems/mirror-reflection/
#There is a special square room with mirrors on each of the four walls. Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.
#The square room has walls of length p and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.
#Given the two integers p and q, return the number of the receptor that the ray meets first.
#The test cases are guaranteed so that the ray will meet a receptor eventually.


class Solution(object):
    def mirrorReflection(self, p, q):
        """
        :type p: int
        :type q: int
        :rtype: int
        """       
        if p == q:
            return 1
        elif p > q:
            if (p/q) % 2 == 0:
                return 2
            else:
                return 1
        else:
            if (q/p) % 2 == 0:
                return 0
            else:
                return 1

        

    