#https://leetcode.com/problems/orderly-queue/
#You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string..
#Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.


class Solution(object):
    def orderlyQueue(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        if not s:
            return ""
        if k==1:
            result=s
            for i in range(1,len(s)):
                s=s[1:]+s[0]
                if s<result:
                    result=s
            return result
        else:
            return "".join(sorted(s))
        
        
    