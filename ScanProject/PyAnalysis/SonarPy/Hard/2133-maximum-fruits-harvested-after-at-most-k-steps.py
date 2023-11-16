#https://leetcode.com/problems/maximum-fruits-harvested-after-at-most-k-steps/
#Fruits are available at some positions on an infinite x-axis. You are given a 2D integer array fruits where fruits[i] = [positioni, amounti] depicts amounti fruits at the position positioni. fruits is already sorted by positioni in ascending order, and each positioni is unique.
#You are also given an integer startPos and an integer k. Initially, you are at the position startPos. From any position, you can either walk to the left or right. It takes one step to move one unit on the x-axis, and you can walk at most k steps in total. For every position you reach, you harvest all the fruits at that position, and the fruits will disappear from that position.
#Return the maximum total number of fruits you can harvest.


class Solution(object):
    def maxTotalFruits(self, fruits, startPos, k):
        """
        :type fruits: List[List[int]]
        :type startPos: int
        :type k: int
        :rtype: int
        """
        n = len(fruits)
        res = 0
        l = r = startPos
        count = collections.Counter()
        count[fruits[l][1]] += fruits[l][1]
        res = max(res, count[fruits[l][1]])
        while l > 0 or r < n-1:
            if l > 0 and (r == n-1 or fruits[l-1][0] - fruits[l][0] < fruits[r+1][0] - fruits[r][0]):
                l -= 1
                count[fruits[l][1]] += fruits[l][1]
                if count[fruits[l][1]] == fruits[l][1]:
                    res = max(res, count[fruits[l][1]])
            else:
                r += 1
                count[fruits[r][1]] += fruits[r][1]
                if count[fruits[r][1]] == fruits[r][1]:
                    res = max(res, count[fruits[r][1]])
            while r - l + 1 > k:
                count[fruits[l][1]] -= fruits[l][1]
                if count[fruits[l][1]] == 0:
                    del count[fruits[l][1]]
                l += 1
            while r - l + 1 <= k:
                res = max(res, sum(count.values()))
                if r == n-1:
                    break
                r += 1
                count[fruits[r][1]] += fruits[r][1]
                if count[fruits[r][1]] == fruits[r][1]:
                    res = max(res, count[fruits[r][1]])
        return res

        
        
    