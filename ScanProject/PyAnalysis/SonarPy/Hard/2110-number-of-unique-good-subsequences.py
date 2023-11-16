#https://leetcode.com/problems/number-of-unique-good-subsequences/
#You are given a binary string binary. A subsequence of binary is considered good if it is not empty and has no leading zeros (with the exception of "0").
#Find the number of unique good subsequences of binary.
#For example, if binary = "001", then all the good subsequences are ["0", "0", "1"], so the unique good subsequences are "0" and "1". Note that subsequences "00", "01", and "001" are not good because they have leading zeros.
#Return the number of unique good subsequences of binary. Since the answer may be very large, return it modulo 109 + 7.
#A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.


class Solution(object):
    def numberOfUniqueGoodSubsequences(self, binary):
        """
        :type binary: str
        :rtype: int
        """
        n = len(binary)
        dp = [0] * (n + 1)
        dp[0] = 1
        last = [-1] * 2
        for i in range(n):
            dp[i + 1] = (dp[i] * 2) % (10**9 + 7)
            if last[int(binary[i])] >= 0:
                dp[i + 1] -= dp[last[int(binary[i])]]
            last[int(binary[i])] = i
        if '0' in binary:
            return dp[-1] - 1
        else:
            return dp[-1]
        
        
    