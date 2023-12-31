#https://leetcode.com/problems/number-of-ways-to-separate-numbers/
#You wrote down many positive integers in a string called num. However, you realized that you forgot to add commas to seperate the different numbers. You remember that the list of integers was non-decreasing and that no integer had leading zeros.
#Return the number of possible lists of integers that you could have written down to get the string num. Since the answer may be large, return it modulo 109 + 7.


class Solution(object):
    def numberOfCombinations(self, num):
        """
        :type num: str
        :rtype: int
        """
        n = len(num)
        @lru_cache(None)
        def dp(i, prev):
            if i == n:
                return 1
            res = 0
            curr = 0
            for j in range(i, n):
                curr = curr * 10 + int(num[j])
                if curr < prev:
                    continue
                res += dp(j + 1, curr)
            return res
        return dp(0, 0) % (10**9 + 7)

        
        
    