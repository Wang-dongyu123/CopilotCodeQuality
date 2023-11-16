#https://leetcode.com/problems/numbers-with-same-consecutive-differences/
#Given two integers n and k, return an array of all the integers of length n where the difference between every two consecutive digits is k. You may return the answer in any order.
#Note that the integers should not have leading zeros. Integers as 02 and 043 are not allowed.


class Solution(object):
    def numsSameConsecDiff(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[int]
        """
        def check(x):
            if x < 10**(n-1):
                return False
            if x > 10**n - 1:
                return False
            return True
        def dfs(n, k, item, res):
            if len(item) == n:
                res.append(int("".join(map(str, item))))
                return
            for i in range(10):
                if not item and i == 0:
                    continue
                if not item or abs(item[-1] - i) == k:
                    item.append(i)
                    dfs(n, k, item, res)
                    item.pop()
        res = []
        dfs(n, k, [], res)
        return res

        

    