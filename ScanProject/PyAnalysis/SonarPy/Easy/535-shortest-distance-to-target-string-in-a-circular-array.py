#https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/
#You are given a 0-indexed circular string array words and a string target. A circular array means that the array's end connects to the array's beginning.
#Formally, the next element of words[i] is words[(i + 1) % n] and the previous element of words[i] is words[(i - 1 + n) % n], where n is the length of words.
#Starting from startIndex, you can move to either the next word or the previous word with 1 step at a time.
#Return the shortest distance needed to reach the string target. If the string target does not exist in words, return -1.


class Solution(object):
    def closetTarget(self, words, target, startIndex):
        """
        :type words: List[str]
        :type target: str
        :type startIndex: int
        :rtype: int
        """      
        n=len(words)
        result=n
        for i in range(n):
            if words[i]==target:
                result=min(result,min(abs(i-startIndex),n-abs(i-startIndex)))
        if result==n:
            return -1
        return result
        

    