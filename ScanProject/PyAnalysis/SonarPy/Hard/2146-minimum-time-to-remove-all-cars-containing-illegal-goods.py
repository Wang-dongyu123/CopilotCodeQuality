#https://leetcode.com/problems/minimum-time-to-remove-all-cars-containing-illegal-goods/
#You are given a 0-indexed binary string s which represents a sequence of train cars. s[i] = '0' denotes that the ith car does not contain illegal goods and s[i] = '1' denotes that the ith car does contain illegal goods.
#As the train conductor, you would like to get rid of all the cars containing illegal goods. You can do any of the following three operations any number of times:
#Remove a train car from the left end (i.e., remove s[0]) which takes 1 unit of time.
#Remove a train car from the right end (i.e., remove s[s.length - 1]) which takes 1 unit of time.
#Remove a train car from anywhere in the sequence which takes 2 units of time.
#Return the minimum time to remove all the cars containing illegal goods.
#Note that an empty sequence of cars is considered to have no cars containing illegal goods.


class Solution(object):
    def minimumTime(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        presum = [0]
        for x in s:
            presum.append(presum[-1] + int(x))
        res = n
        for i in range(n + 1):
            res = min(res, presum[i] + (n - i - (presum[-1] - presum[i])))
        return res
        
        
    