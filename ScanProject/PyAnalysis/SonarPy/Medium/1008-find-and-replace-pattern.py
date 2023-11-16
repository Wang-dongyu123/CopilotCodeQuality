#https://leetcode.com/problems/find-and-replace-pattern/
#Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.
#A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
#Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.


class Solution(object):
    def findAndReplacePattern(self, words, pattern):
        """
        :type words: List[str]
        :type pattern: str
        :rtype: List[str]
        """
        res = []
        for word in words:
            if self.isMatch(word, pattern):
                res.append(word)
        return res
    def isMatch(word, pattern):
            d = {}
            for i in range(len(word)):
                if word[i] in d:
                    if d[word[i]] != pattern[i]:
                        return False
                else:
                    if pattern[i] in d.values():
                        return False
                    d[word[i]] = pattern[i]
            return True
        

    