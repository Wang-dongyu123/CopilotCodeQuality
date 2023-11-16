#https://leetcode.com/problems/sum-of-k-mirror-numbers/
#A k-mirror number is a positive integer without leading zeros that reads the same both forward and backward in base-10 as well as in base-k.
#For example, 9 is a 2-mirror number. The representation of 9 in base-10 and base-2 are 9 and 1001 respectively, which read the same both forward and backward.
#On the contrary, 4 is not a 2-mirror number. The representation of 4 in base-2 is 100, which does not read the same both forward and backward.
#Given the base k and the number n, return the sum of the n smallest k-mirror numbers.


class Solution(object):
    def kMirror(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: int
        """
        if n == 0:
            return 0
        res = 1
        for i in range(n-1):
            cur = res
            while cur:
                res = res * k + cur % k
                cur /= k
        return res
        
        
    