#https://leetcode.com/problems/number-of-beautiful-partitions/
#You are given a string s that consists of the digits '1' to '9' and two integers k and minLength.
#A partition of s is called beautiful if:
#s is partitioned into k non-intersecting substrings.
#Each substring has a length of at least minLength.
#Each substring starts with a prime digit and ends with a non-prime digit. Prime digits are '2', '3', '5', and '7', and the rest of the digits are non-prime.
#Return the number of beautiful partitions of s. Since the answer may be very large, return it modulo 109 + 7.
#A substring is a contiguous sequence of characters within a string.


class Solution(object):
    def beautifulPartitions(self, s, k, minLength):
        """
        :type s: str
        :type k: int
        :type minLength: int
        :rtype: int
        """
        n = len(s)
        ans = 0
        seen = [-1] + [n] * 1023
        mask = 0
        for i in range(n):
            mask ^= 1 << int(s[i])
            seen[mask] = min(seen[mask], i)
            for j in range(10):
                ans += seen[mask ^ (1 << j)] <= i - k
        return ans
        
        
    