#https://leetcode.com/problems/total-appeal-of-a-string/
#The appeal of a string is the number of distinct characters found in the string.
#For example, the appeal of "abbca" is 3 because it has 3 distinct characters: 'a', 'b', and 'c'.
#Given a string s, return the total appeal of all of its substrings.
#A substring is a contiguous sequence of characters within a string.


class Solution(object):
    def appealSum(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        ans = 0
        for i in range(n):
            cnt = [0] * 26
            for j in range(i, n):
                cnt[ord(s[j]) - ord('a')] += 1
                ans += sum(x > 0 for x in cnt)
        return ans
        
        
    