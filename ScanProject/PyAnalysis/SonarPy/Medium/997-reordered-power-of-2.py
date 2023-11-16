#https://leetcode.com/problems/reordered-power-of-2/
#You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
#Return true if and only if we can do this so that the resulting number is a power of two.


class Solution(object):
    def reorderedPowerOf2(self, n):
        """
        :type n: int
        :rtype: bool
        """ 

        def check(x):
            x = str(x)
            if len(x) != len(str(n)):
                return False
            for i in range(len(x)):
                if x[i] != str(n)[i]:
                    return False
            return True
        n = str(n)
        for i in range(31):
            if check(1 << i):
                return True
        return False

    