#https://leetcode.com/problems/palindrome-partitioning/
#Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.


class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """  
        def isPalindrome(s):
            return s == s[::-1]
        def dfs(s, item, res):
            if not s:
                res.append(item[:])
            for i in range(1, len(s) + 1):
                if isPalindrome(s[:i]):
                    item.append(s[:i])
                    dfs(s[i:], item, res)
                    item.pop()
        res = []
        dfs(s,[],res)
        return res

        

    