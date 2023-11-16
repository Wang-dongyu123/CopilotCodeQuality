#https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/
#Given two strings s and t, transform string s into string t using the following operation any number of times:
#Choose a non-empty substring in s and sort it in place so the characters are in ascending order.
#For example, applying the operation on the underlined substring in "14234" results in "12344".
#Return true if it is possible to transform s into t. Otherwise, return false.
#A substring is a contiguous sequence of characters within a string.


class Solution(object):
    def isTransformable(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        n = len(s)
        m = len(t)
        if n != m:
            return False
        s = list(s)
        t = list(t)
        pos = [[] for _ in range(10)]
        for i in range(n):
            pos[ord(s[i]) - ord('0')].append(i)
        for i in range(n):
            d = ord(t[i]) - ord('0')
            if not pos[d]:
                return False
            for j in range(d):
                if pos[j] and pos[j][-1] < pos[d][-1]:
                    return False
            pos[d].pop()
        return True
        
        
        
        
    